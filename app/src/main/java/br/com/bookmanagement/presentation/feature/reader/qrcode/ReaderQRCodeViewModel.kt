package br.com.bookmanagement.presentation.feature.reader.qrcode

import androidx.lifecycle.viewModelScope
import br.com.bookmanagement.domain.usecase.ReaderQRCodeUseCase
import br.com.bookmanagement.presentation.util.BaseViewModel
import kotlinx.coroutines.launch

class ReaderQRCodeViewModel(
    private val readerQRCodeUseCase: ReaderQRCodeUseCase
) : BaseViewModel<QRCodeUiState>(QRCodeUiState.OpenQRCode) {

    fun fetchData(query: String) {
        viewModelScope.launch {
            uiStateAccess.value = QRCodeUiState.Loading(true)
            readerQRCodeUseCase.getData(query).collect { result ->
                result.fold(
                    onSuccess = { data ->
                        uiStateAccess.value = QRCodeUiState.Success(data)
                    },
                    onFailure = { error ->
                        uiStateAccess.value = QRCodeUiState.Error(error)
                    }
                )
            }
        }
    }
}
package br.com.bookmanagement.presentation.feature.reader.qrcode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.bookmanagement.domain.usecase.ReaderQRCodeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ReaderQRCodeViewModel(
    private val readerQRCodeUseCase: ReaderQRCodeUseCase
) : ViewModel() {

    private val _readerQRCodeState = MutableStateFlow<QRCodeUiState>(QRCodeUiState.OpenQRCode)
    val readerQRCodeState: StateFlow<QRCodeUiState> = _readerQRCodeState

    fun fetchData(query: String) {
        viewModelScope.launch {
            _readerQRCodeState.value = QRCodeUiState.Loading(true)
            readerQRCodeUseCase.getData(query).collect { result ->
                result.fold(
                    onSuccess = { data ->
                        _readerQRCodeState.value = QRCodeUiState.Success(data)
                    },
                    onFailure = { error ->
                        _readerQRCodeState.value = QRCodeUiState.Error(error)
                    }
                )
            }
        }
    }
}
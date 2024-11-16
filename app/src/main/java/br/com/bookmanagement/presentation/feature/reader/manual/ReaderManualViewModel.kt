package br.com.bookmanagement.presentation.feature.reader.manual

import androidx.lifecycle.viewModelScope
import br.com.bookmanagement.domain.usecase.ReaderManualUseCase
import br.com.bookmanagement.presentation.BookManagementUiState
import br.com.bookmanagement.presentation.util.BaseViewModel
import kotlinx.coroutines.launch

class ReaderManualViewModel(
    private val readerManualUseCase: ReaderManualUseCase
) : BaseViewModel<BookManagementUiState>(BookManagementUiState.Loading(true)) {
    fun fetchData(query: String) {
        viewModelScope.launch {
            uiStateAccess.value = BookManagementUiState.Loading(true)
            readerManualUseCase.getData(query).collect { result ->
                   result.fold(
                       onSuccess = { data ->
                           uiStateAccess.value = BookManagementUiState.Success(data)
                       },
                       onFailure = { error ->
                           uiStateAccess.value = BookManagementUiState.Error(error)
                       }
                   )
            }
        }
    }
}
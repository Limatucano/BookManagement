package br.com.bookmanagement.presentation.feature.reader.manual

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.bookmanagement.domain.model.Books
import br.com.bookmanagement.domain.usecase.ReaderManualUseCase
import br.com.bookmanagement.presentation.BookManagementUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ReaderManualViewModel(
    private val readerManualUseCase: ReaderManualUseCase
) : ViewModel() {

    private val _readerManualState = MutableStateFlow<BookManagementUiState<Books>>(BookManagementUiState.Loading(true))
    val readerManualState: StateFlow<BookManagementUiState<Books>> = _readerManualState

    fun fetchData(query: String) {
        viewModelScope.launch {
            _readerManualState.value = BookManagementUiState.Loading(true)
            readerManualUseCase.getData(query).collect { result ->
                   result.fold(
                       onSuccess = { data ->
                           _readerManualState.value = BookManagementUiState.Success(data)
                       },
                       onFailure = { error ->
                           _readerManualState.value = BookManagementUiState.Error(error)
                       }
                   )
            }
        }
    }
}
package br.com.bookmanagement.presentation

import br.com.bookmanagement.domain.model.Books

sealed class BookManagementUiState {
    data class Loading(val show: Boolean): BookManagementUiState()
    data class Error(val throwable: Throwable): BookManagementUiState()
    data class Success(val item: Books): BookManagementUiState()
}
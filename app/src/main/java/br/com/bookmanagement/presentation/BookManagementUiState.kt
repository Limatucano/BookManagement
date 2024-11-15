package br.com.bookmanagement.presentation

sealed class BookManagementUiState<out T> {
    data class Loading(val show: Boolean): BookManagementUiState<Nothing>()
    data class Error(val trhowable: Throwable): BookManagementUiState<Nothing>()
    data class Success<T>(val item: T): BookManagementUiState<T>()
}
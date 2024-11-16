package br.com.bookmanagement.data.remote.model

data class BooksDto(
    val totalItems: Int?,
    val items: List<BookDto>?
)
package br.com.bookmanagement.data.remote.model

data class BooksResponse(
    val totalItems: Int,
    val items: List<BookResponse>
)
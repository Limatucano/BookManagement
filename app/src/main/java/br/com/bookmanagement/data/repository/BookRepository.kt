package br.com.bookmanagement.data.repository

import br.com.bookmanagement.data.remote.model.BooksDto
import br.com.bookmanagement.data.remote.service.ApiService

class BookRepository(
    private val bookService: ApiService
) : IBookRepository {

    override suspend fun getVolumes(query: String): BooksDto {
        return bookService.getVolumes(query)
    }
}
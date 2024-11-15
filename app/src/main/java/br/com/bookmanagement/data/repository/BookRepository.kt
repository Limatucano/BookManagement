package br.com.bookmanagement.data.repository

import br.com.bookmanagement.data.remote.datasource.RemoteDataSourceImpl
import br.com.bookmanagement.data.remote.model.BooksDto

class BookRepository(
    private val bookService: RemoteDataSourceImpl
) : IBookRepository {

    override suspend fun getVolumesByTitle(query: String): BooksDto {
        return bookService.getVolumesByTitle(query)
    }
}
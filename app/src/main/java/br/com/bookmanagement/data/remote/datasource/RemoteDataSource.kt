package br.com.bookmanagement.data.remote.datasource

import br.com.bookmanagement.data.remote.model.BooksDto
import br.com.bookmanagement.data.remote.service.ApiService

interface RemoteDataSource {
    suspend fun getVolumesByIsbn(isbn: String): BooksDto
    suspend fun getVolumesByTitle(title: String): BooksDto
}

class RemoteDataSourceImpl(
    private val service: ApiService
) : RemoteDataSource {
    override suspend fun getVolumesByIsbn(isbn: String): BooksDto {
        return service.getVolumes("isbn:$isbn")
    }

    override suspend fun getVolumesByTitle(title: String): BooksDto {
        return service.getVolumes("title:$title")
    }
}
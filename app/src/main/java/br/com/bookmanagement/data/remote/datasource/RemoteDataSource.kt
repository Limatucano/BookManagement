package br.com.bookmanagement.data.remote.datasource

import br.com.bookmanagement.data.remote.model.BooksResponse
import br.com.bookmanagement.data.remote.service.ApiService

interface RemoteDataSource {
    suspend fun getVolumesByIsbn(isbn: String): BooksResponse
    suspend fun getVolumesByTitle(title: String): BooksResponse
}

class RemoteDataSourceImpl(
    private val service: ApiService
) : RemoteDataSource {
    override suspend fun getVolumesByIsbn(isbn: String): BooksResponse {
        return service.getVolumes("isbn:$isbn")
    }

    override suspend fun getVolumesByTitle(title: String): BooksResponse {
        return service.getVolumes("title:$title")
    }
}
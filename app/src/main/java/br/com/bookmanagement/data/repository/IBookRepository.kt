package br.com.bookmanagement.data.repository

import br.com.bookmanagement.data.remote.model.BooksDto

interface IBookRepository {

    suspend fun getVolumesByTitle(query: String): BooksDto

    suspend fun getVolumesByIsbn(query: String): BooksDto

}
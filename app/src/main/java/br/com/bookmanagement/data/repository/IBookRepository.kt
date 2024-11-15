package br.com.bookmanagement.data.repository

import br.com.bookmanagement.data.remote.model.BooksDto

interface IBookRepository {

    suspend fun getVolumes(query: String): BooksDto

}
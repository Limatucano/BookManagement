package br.com.bookmanagement.data.remote.service

import br.com.bookmanagement.data.remote.model.BooksDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("volumes")
    fun getVolumes(
        @Query("q") query: String
    ): BooksDto

}
package br.com.bookmanagement.data.remote.datasource

import br.com.bookmanagement.data.remote.service.ApiService

interface RemoteDataSource {

}

class RemoteDataSourceImpl(
    private val service: ApiService
) : RemoteDataSource {

}
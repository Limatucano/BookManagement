package br.com.bookmanagement.di

import br.com.bookmanagement.data.remote.datasource.RemoteDataSource
import br.com.bookmanagement.data.remote.datasource.RemoteDataSourceImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal object DataModule: KoinModule {
    override val module: Module = module {
        singleOf(::RemoteDataSourceImpl) bind RemoteDataSource::class
    }
}
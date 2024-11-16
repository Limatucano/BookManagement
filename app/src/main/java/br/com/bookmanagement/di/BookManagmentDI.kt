package br.com.bookmanagement.di

import br.com.bookmanagement.data.repository.BookRepositoryImpl
import br.com.bookmanagement.data.repository.IBookRepository
import br.com.bookmanagement.domain.usecase.ReaderManualUseCase
import br.com.bookmanagement.presentation.feature.reader.manual.ReaderManualViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object BookManagmentDI {
    val bookModule = module {
        factory<IBookRepository> {
            BookRepositoryImpl(
                get()
            )
        }
        single {
            ReaderManualUseCase(get())
        }
        viewModel { ReaderManualViewModel(get()) }
    }
}
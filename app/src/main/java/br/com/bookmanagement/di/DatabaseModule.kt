package br.com.bookmanagement.di

import android.content.Context
import androidx.room.Room
import br.com.bookmanagement.data.local.database.BookDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

internal object DatabaseModule: KoinModule {
    override val module: Module = module {
        single {
            providesBookDatabase(
                context = androidContext()
            )
        }
        single {
            get<BookDataBase>().bookDao()
        }
    }

    private fun providesBookDatabase(
        context: Context
    ): BookDataBase {
        return Room.databaseBuilder(
            context = context,
            klass = BookDataBase::class.java,
            name = "book_database"
        ).build()
    }
}
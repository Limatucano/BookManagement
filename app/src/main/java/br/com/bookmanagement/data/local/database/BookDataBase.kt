package br.com.bookmanagement.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.bookmanagement.data.local.dao.BookDao
import br.com.bookmanagement.data.local.entity.Book
import br.com.bookmanagement.data.local.typeconverter.ListStringConverter

@Database(entities = [Book::class], version = 1)
@TypeConverters(ListStringConverter::class)
abstract class BookDataBase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}
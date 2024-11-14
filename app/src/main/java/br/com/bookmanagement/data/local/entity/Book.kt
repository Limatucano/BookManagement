package br.com.bookmanagement.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey val id: String,
    val title: String,
    val isbn13: String,
    val isbn10: String,
    val description: String,
    val publishedYear: String,
    val imageUrl: String?,
    val authors: List<String>,
    val subtitle: String?,
    val categories: List<String>,
    val pageCount: Int,
    val isFavorite: Boolean,
    val isWishList: Boolean,
    val averageRating: Float
)
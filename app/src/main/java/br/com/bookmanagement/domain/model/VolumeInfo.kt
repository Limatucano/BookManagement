package br.com.bookmanagement.domain.model

data class VolumeInfo(
    val title: String,
    val subtitle: String,
    val authors: List<String>,
    val publishedDate: String,
    val description: String,
    val industryIdentifiers: List<IndustryIdentifier>,
    val pageCount: Int,
    val categories: List<String>,
    val averageRating: Float,
    val imageLinks: ImageLink,
    val language: String
)

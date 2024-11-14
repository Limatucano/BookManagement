package br.com.bookmanagement.data.remote.model

data class VolumeInfoResponse(
    val title: String,
    val subtitle: String,
    val authors: List<String>,
    val publishedDate: String,
    val description: String,
    val industryIdentifiers: List<IndustryIdentifierResponse>,
    val pageCount: Int,
    val categories: List<String>,
    val averageRating: Float,
    val imageLinks: ImageLinkResponse,
    val language: String
)

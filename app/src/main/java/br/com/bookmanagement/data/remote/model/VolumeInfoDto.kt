package br.com.bookmanagement.data.remote.model

data class VolumeInfoDto(
    val title: String?,
    val subtitle: String?,
    val authors: List<String>?,
    val publishedDate: String?,
    val description: String?,
    val industryIdentifiers: List<IndustryIdentifierDto>?,
    val pageCount: Int?,
    val categories: List<String>?,
    val averageRating: Float?,
    val imageLinks: ImageLinkDto?,
    val language: String?
)

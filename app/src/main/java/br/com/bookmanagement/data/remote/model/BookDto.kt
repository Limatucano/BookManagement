package br.com.bookmanagement.data.remote.model

data class BookDto(
    val kind: String?,
    val id: String?,
    val volumeInfo: VolumeInfoDto?
)


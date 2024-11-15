package br.com.bookmanagement.domain.model

data class Book(
    val kind: String,
    val id: String,
    val volumeInfo: VolumeInfo
)
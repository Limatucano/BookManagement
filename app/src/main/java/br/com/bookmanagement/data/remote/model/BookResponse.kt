package br.com.bookmanagement.data.remote.model

data class BookResponse(
    val kind: String,
    val id: String,
    val volumeInfo: VolumeInfoResponse
)


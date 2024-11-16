package br.com.bookmanagement.presentation.feature.reader.qrcode

import br.com.bookmanagement.domain.model.Books

sealed class QRCodeUiState {
    data class Loading(val show: Boolean) : QRCodeUiState()
    data class Error(val throwable: Throwable?) : QRCodeUiState()
    data object OpenQRCode : QRCodeUiState()
    data class Success(val item: Books) : QRCodeUiState()
}
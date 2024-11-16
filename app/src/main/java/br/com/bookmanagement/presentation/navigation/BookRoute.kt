package br.com.bookmanagement.presentation.navigation

sealed class BookRoute(val route: String) {

    data object SplashScreen : BookRoute(route = "book_splash_screen")

    data object HomeScreen : BookRoute(route = "book_home_screen")

    data object DetailsScreen : BookRoute(route = "book_details_screen")

    data object ReaderQRCodeScreen : BookRoute(route = "book_reader_qrcode_screen")

    data object ReaderManualScreen : BookRoute(route = "book_reader_manual_screen")

}
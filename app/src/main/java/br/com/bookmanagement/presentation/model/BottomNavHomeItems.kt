package br.com.bookmanagement.presentation.model

import br.com.design_system.R
import br.com.bookmanagement.presentation.navigation.BookRoute
import br.com.design_system.model.BottomNavItem

sealed class BottomNavHomeItems : BottomNavItem {
    data object Search : BottomNavHomeItems() {
        override val route: String = BookRoute.ReaderManualScreen.route
        override val icon: Int = R.drawable.ic_search
    }
    data object Home : BottomNavHomeItems() {
        override val route: String = BookRoute.HomeScreen.route
        override val icon: Int = R.drawable.ic_home
    }
    data object QrCode : BottomNavHomeItems() {
        override val route: String = BookRoute.ReaderQRCodeScreen.route
        override val icon: Int = R.drawable.ic_qrcode
    }

    companion object {
        fun getAll() = listOf(
            Search,
            Home,
            QrCode
        )

        fun contains(route: String?): Boolean {
            return getAll()
                .map { it.route }
                .contains(route)
        }
    }
}
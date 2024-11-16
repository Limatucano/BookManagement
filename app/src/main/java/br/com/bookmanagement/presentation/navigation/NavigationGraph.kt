package br.com.bookmanagement.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.bookmanagement.presentation.feature.details.DetailsScreen
import br.com.bookmanagement.presentation.feature.home.HomeScreen
import br.com.bookmanagement.presentation.feature.reader.manual.ReaderManualScreen
import br.com.bookmanagement.presentation.feature.reader.qrcode.ReaderQRCodeScreen
import br.com.bookmanagement.presentation.feature.splash.SplashScreen

@Composable
internal fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BookRoute.ReaderQRCodeScreen.route
    ) {
        composable(route = BookRoute.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = BookRoute.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = BookRoute.DetailsScreen.route) {
            DetailsScreen(navController = navController)
        }

        composable(route = BookRoute.ReaderQRCodeScreen.route) {
            ReaderQRCodeScreen(navController = navController)
        }

        composable(route = BookRoute.ReaderManualScreen.route) {
            ReaderManualScreen(navController = navController)
        }
    }
}
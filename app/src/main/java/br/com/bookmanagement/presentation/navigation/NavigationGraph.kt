package br.com.bookmanagement.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
internal fun NavigationGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = BookRoute.SplashScreen.route
    ) {
        composable(route = BookRoute.SplashScreen.route) {

        }

        composable(route = BookRoute.HomeScreen.route) {

        }

        composable(route = BookRoute.DetailsScreen.route) {

        }

        composable(route = BookRoute.ReaderQRCodeScreen.route) {

        }

        composable(route = BookRoute.ReaderManualScreen.route) {

        }

    }
}
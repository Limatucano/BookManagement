package br.com.bookmanagement.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.bookmanagement.presentation.feature.details.DetailsScreen
import br.com.bookmanagement.presentation.feature.home.HomeScreen
import br.com.bookmanagement.presentation.feature.reader.manual.ReaderManualScreen
import br.com.bookmanagement.presentation.feature.reader.qrcode.ReaderQRCodeScreen
import br.com.bookmanagement.presentation.feature.splash.SplashScreen
import br.com.bookmanagement.presentation.model.BottomNavHomeItems
import br.com.design_system.components.atomic.organism.ScaffoldOrganism
import br.com.design_system.theme.LightTheme
import br.com.design_system.theme.TransparentTheme

@Composable
internal fun NavigationGraph(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    ScaffoldOrganism(
        navController = navController,
        items = BottomNavHomeItems.getAll(),
        showBottomNavigation = BottomNavHomeItems.contains(currentRoute),
        shouldUsePaddingValues = currentRoute != BookRoute.ReaderQRCodeScreen.route
    ) {
        NavHost(
            navController = navController,
            startDestination = BookRoute.HomeScreen.route
        ) {
            composable(route = BookRoute.HomeScreen.route) {
                LightTheme {
                    HomeScreen(navController = navController)
                }
            }

            composable(route = BookRoute.DetailsScreen.route) {
                LightTheme {
                    DetailsScreen(navController = navController)
                }
            }

            composable(route = BookRoute.ReaderQRCodeScreen.route) {
                TransparentTheme {
                    ReaderQRCodeScreen(navController = navController)
                }
            }

            composable(route = BookRoute.SplashScreen.route) {
                LightTheme {
                    SplashScreen(navController = navController)
                }
            }

            composable(route = BookRoute.ReaderManualScreen.route) {
                LightTheme {
                    ReaderManualScreen(navController = navController)
                }
            }
        }
    }
}
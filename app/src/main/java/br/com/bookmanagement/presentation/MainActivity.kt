package br.com.bookmanagement.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import br.com.bookmanagement.di.BookManagmentDI
import br.com.bookmanagement.presentation.navigation.NavigationGraph
import br.com.design_system.theme.BookManagementTheme
import org.koin.core.context.loadKoinModules

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadKoinModules(BookManagmentDI.bookModule)

        setContent {
            BookManagementTheme {
                val navController = rememberNavController()

                NavigationGraph(navController = navController)
            }
        }
    }
}
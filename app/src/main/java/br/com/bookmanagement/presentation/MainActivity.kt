package br.com.bookmanagement.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.bookmanagement.di.BookManagmentDI
import br.com.bookmanagement.presentation.navigation.NavigationGraph
import br.com.bookmanagement.ui.theme.BookManagementTheme
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
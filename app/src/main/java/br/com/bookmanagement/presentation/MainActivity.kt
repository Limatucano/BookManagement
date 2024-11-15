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
import br.com.bookmanagement.presentation.navigation.NavigationGraph
import br.com.bookmanagement.ui.theme.BookManagementTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookManagementTheme {
                val navController = rememberNavController()

                CallNavigation(navController = navController)
            }
        }
    }

    @Composable
    private fun CallNavigation(navController: NavHostController) {
        NavigationGraph(navController = navController)
    }

}
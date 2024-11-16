package br.com.bookmanagement.presentation.feature.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.bookmanagement.presentation.model.BottomNavHomeItems
import br.com.design_system.components.atomic.organism.ScaffoldOrganism
import br.com.design_system.theme.colorsMain

@Composable
fun HomeScreen(navController: NavController) {
    ScaffoldOrganism(
        navController = navController,
        items = BottomNavHomeItems.getAll()
    ) {
        Button(onClick = { }) {
            Text(text = "Clique")
        }
    }
}
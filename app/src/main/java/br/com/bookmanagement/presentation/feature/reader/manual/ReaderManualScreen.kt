package br.com.bookmanagement.presentation.feature.reader.manual

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import br.com.bookmanagement.presentation.model.BottomNavHomeItems
import br.com.design_system.components.atomic.organism.ScaffoldOrganism
import br.com.design_system.theme.colorsMain
import org.koin.androidx.compose.koinViewModel

@Composable
fun ReaderManualScreen(
    navController: NavController,
    viewModel: ReaderManualViewModel = koinViewModel()
) {
    ScaffoldOrganism(
        navController = navController,
        items = BottomNavHomeItems.getAll()
    ) {
        Button(onClick = { viewModel.fetchData("Jogos Vorazes") }) {
            Text(text = "Clique")
        }
    }
}
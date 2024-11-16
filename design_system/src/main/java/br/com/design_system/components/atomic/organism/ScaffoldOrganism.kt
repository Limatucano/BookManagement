package br.com.design_system.components.atomic.organism

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import br.com.design_system.model.BottomNavItem

@Composable
fun ScaffoldOrganism(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    items: List<BottomNavItem>,
    navController: NavController,
    backgroundColor: Color = Color.Transparent,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        containerColor = backgroundColor,
        contentColor = backgroundColor,
        bottomBar = {
            BottomNavigationOrganism(
                containerColor = backgroundColor,
                items = items,
                navController = navController
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            content()
        }
    }
}
package br.com.design_system.components.atomic.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.design_system.model.BottomNavItem
import br.com.design_system.theme.colorsMain
import br.com.design_system.theme.colorsSecondary

@Composable
fun BottomNavigationOrganism(
    modifier: Modifier = Modifier,
    items: List<BottomNavItem>,
    containerColor: Color = Color.Transparent,
    tonalElevation: Dp = NavigationBarDefaults.Elevation,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    navController: NavController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = modifier,
        containerColor = containerColor,
        windowInsets = windowInsets,
        tonalElevation = tonalElevation
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            items.forEach { item ->
                val (backgroundColor, iconColor, iconHeight) = if (currentRoute == item.route) {
                    Triple(colorsMain.buttonBackground, colorsSecondary.buttonBackground, 68.dp)
                } else {
                    Triple(colorsSecondary.buttonBackground, colorsMain.buttonBackground, 58.dp)
                }
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = backgroundColor)
                        .height(iconHeight)
                        .padding(18.dp)
                        .clickable {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(item.icon),
                        tint = iconColor,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
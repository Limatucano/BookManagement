package br.com.design_system.theme

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    background = colorsMain.background,
    onBackground = colorsMain.text,
    surface = colorsMain.background,
    error = colorsMain.inactiveBackground,
    onError = colorsMain.inactiveContent,
    primary = colorsMain.buttonBackground,
    onPrimary = colorsMain.white
)

@Composable
fun LightTheme(
    content: @Composable () -> Unit
) {
    val context = LocalContext.current as ComponentActivity

    context.enableEdgeToEdge(
        statusBarStyle = SystemBarStyle.light(
            colorsMain.background.toArgb(),
            Color.Black.toArgb()
        ),
        navigationBarStyle = SystemBarStyle.light(
            colorsMain.background.toArgb(),
            Color.Black.toArgb()
        ),
    )

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun TransparentTheme(
    content: @Composable () -> Unit
) {
    val context = LocalContext.current as ComponentActivity

    context.enableEdgeToEdge(
        statusBarStyle = SystemBarStyle.dark(
            Color.Transparent.toArgb()
        ),
        navigationBarStyle = SystemBarStyle.dark(
            Color.Transparent.toArgb()
        ),
    )

    MaterialTheme(
        colorScheme = LightColorScheme.copy(
            background = Color.Transparent,
            onBackground = colorsMain.white,
            primary = Color.Transparent
        ),
        typography = Typography,
        content = content
    )
}
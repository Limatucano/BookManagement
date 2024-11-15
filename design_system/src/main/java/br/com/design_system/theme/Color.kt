package br.com.design_system.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

data class ColorsMain(
    val text: Color = Color(0xFF785D55),
    val buttonBackground: Color = Color(0xFFA06f56),
    val background: Color = Color(0xFFFBFBFB),
    val inactiveBackground: Color = Color(0xFFC7C7C7),
    val inactiveContent: Color = Color(0xFFFEFEFE),
    val error: Color = Color(0xFFC24240),
    val warning: Color = Color(0xFFECB033),
    val success: Color = Color(0xFF90C754)
)

data class ColorsSecondary(
    val text: Color = Color(0xFFF9F6F3),
    val buttonBackground: Color = Color(0xFF785D55)
)

val colorsMain = ColorsMain()
val colorsSecondary = ColorsSecondary()
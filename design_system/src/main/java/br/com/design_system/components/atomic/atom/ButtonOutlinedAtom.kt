package br.com.design_system.components.atomic.atom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.design_system.theme.Typography
import br.com.design_system.theme.colorsMain

@Composable
fun ButtonOutlinedAtom(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    contentColor: Color = colorsMain.buttonBackground,
    textStyle: TextStyle
) {
    val bankClick = {}
    OutlinedButton(
        modifier = modifier.height(45.dp),
        onClick = if(!isLoading) onClick else bankClick,
        enabled = isEnabled,
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor,
            disabledContentColor = colorsMain.inactiveContent
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if(isEnabled) contentColor
            else colorsMain.inactiveContent
        )
    ) {
        ButtonContentAtom(
            isLoading = isLoading,
            contentColor = contentColor,
            label = label,
            textStyle = textStyle
        )
    }
}

@Preview
@Composable
private fun ButtonOutlinedAtomDisabledPreview() {
    ButtonOutlinedAtom(
        onClick = {},
        label = "Ver Todos",
        isEnabled = false,
        textStyle = Typography.bodyMedium
    )
}

@Preview
@Composable
private fun ButtonOutlinedAtomEnabledPreview() {
    ButtonOutlinedAtom(
        onClick = {},
        label = "Ver Todos",
        isEnabled = true,
        textStyle = Typography.bodyMedium
    )
}

@Preview
@Composable
private fun ButtonOutlinedAtomLoadingPreview() {
    ButtonOutlinedAtom(
        onClick = {},
        label = "Ver Todos",
        isEnabled = true,
        isLoading = true,
        textStyle = Typography.bodyMedium
    )
}
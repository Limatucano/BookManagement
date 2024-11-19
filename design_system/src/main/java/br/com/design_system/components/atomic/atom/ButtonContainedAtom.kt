package br.com.design_system.components.atomic.atom

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.design_system.theme.Typography
import br.com.design_system.theme.colorsMain
import br.com.design_system.theme.colorsSecondary

@Composable
fun ButtonContainedAtom(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    backgroundColor: Color = colorsMain.buttonBackground,
    contentColor: Color = colorsSecondary.text,
    textStyle: TextStyle
) {
    val bankClick = {}
    Button(
        modifier = modifier.height(45.dp),
        onClick = if(!isLoading) onClick else bankClick,
        enabled = isEnabled,
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            disabledContainerColor = colorsMain.inactiveBackground,
            contentColor = contentColor,
            disabledContentColor = colorsMain.inactiveContent
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
private fun ButtonContainedAtomDisabledPreview() {
    ButtonContainedAtom(
        onClick = {},
        label = "Ver Todos",
        isEnabled = false,
        textStyle = Typography.bodyMedium
    )
}

@Preview
@Composable
private fun ButtonContainedAtomEnabledPreview() {
    ButtonContainedAtom(
        onClick = {},
        label = "Ver Todos",
        isEnabled = true,
        textStyle = Typography.bodyMedium
    )
}

@Preview
@Composable
private fun ButtonContainedAtomLoadingPreview() {
    ButtonContainedAtom(
        onClick = {},
        label = "Ver Todos",
        isEnabled = true,
        isLoading = true,
        textStyle = Typography.bodyMedium
    )
}
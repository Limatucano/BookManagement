package br.com.design_system.components.atomic.atom

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
internal fun ButtonContentAtom(
    isLoading: Boolean,
    contentColor: Color,
    label: String,
    textStyle: TextStyle
) {
    if(isLoading) {
        CircularProgressIndicator(
            modifier = Modifier.size(14.dp),
            strokeWidth = 1.5.dp,
            color = contentColor
        )
    } else {
        Text(
            text = label,
            style = textStyle,
            textAlign = TextAlign.Center
        )
    }
}
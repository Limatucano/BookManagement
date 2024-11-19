package br.com.design_system.components.atomic.atom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.design_system.theme.Typography
import br.com.design_system.theme.colorsMain

@Composable
fun ErrorMessageAtom(
    message: String
) {
    Text(
       text = message,
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxWidth(),
        color = colorsMain.error,
        style = Typography.bodyMedium
    )
}
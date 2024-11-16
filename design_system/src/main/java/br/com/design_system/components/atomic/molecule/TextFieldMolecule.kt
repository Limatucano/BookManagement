package br.com.design_system.components.atomic.molecule

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.design_system.components.atomic.atom.ErrorMessageAtom
import br.com.design_system.theme.Typography

@Composable
fun TextFieldMolecule(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (String) -> Unit,
    hint: String,
    hintTextStyle: TextStyle = Typography.bodyMedium,
    isEnabled: Boolean = true,
    isReadOnly: Boolean = false,
    isError: Boolean = false,
    errorMessage: String? = null,
    singleLine: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    Column {
        TextField(
            value = text,
            modifier = modifier
                .fillMaxWidth(),
            onValueChange = onValueChanged,
            visualTransformation = visualTransformation,
            singleLine = singleLine,
            enabled = isEnabled,
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            readOnly = isReadOnly,
            isError = isError,
            label = {
                Text(
                    text = hint,
                    style = hintTextStyle,
                    textAlign = TextAlign.Center
                )
            }
        )

        AnimatedVisibility(visible = isError) {
            Spacer(modifier = Modifier.height(4.dp))
            ErrorMessageAtom(
                message = errorMessage.orEmpty()
            )
        }
    }
}

@Preview
@Composable
private fun TextFieldMoleculeErrorPreview() {
    TextFieldMolecule(
        hint = "Testando",
        onValueChanged = {},
        isError = true,
        errorMessage = "Campo inválido",
        text = ""
    )
}

@Preview
@Composable
private fun TextFieldMoleculeNormalPreview() {
    TextFieldMolecule(
        hint = "Testando",
        onValueChanged = {},
        text = ""
    )
}
package br.com.design_system.components.atomic.molecule

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.design_system.R
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
                .height(60.dp)
                .fillMaxWidth(),
            onValueChange = onValueChanged,
            visualTransformation = visualTransformation,
            singleLine = singleLine,
            enabled = isEnabled,
            trailingIcon = trailingIcon,
            leadingIcon = leadingIcon,
            readOnly = isReadOnly,
            shape = RoundedCornerShape(40.dp),
            isError = isError,
            colors = TextFieldDefaults.colors(
                errorIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
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
private fun TextFieldMoleculeSearchPreview() {
    TextFieldMolecule(
        hint = "Testando",
        onValueChanged = {},
        text = "",
        trailingIcon = {
            Image(
                painter = painterResource(android.R.drawable.ic_menu_search),
                contentDescription = null
            )
        }
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
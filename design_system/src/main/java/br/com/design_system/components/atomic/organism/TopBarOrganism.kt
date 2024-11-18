package br.com.design_system.components.atomic.organism

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import br.com.design_system.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarOrganism(
    title: String?,
    titleSize: TextUnit = 24.sp,
    onNavigationBackClicked: (() -> Unit)?,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            title?.let {
                Text(
                    text = it,
                    fontSize = titleSize,
                    style = Typography.bodyMedium,
                )
            }
        },
        navigationIcon = {
            onNavigationBackClicked?.let {
                IconButton(
                    onClick = { onNavigationBackClicked() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Botão de voltar"
                    )
                }
            }
        },
        actions = actions
    )
}

@Preview
@Composable
private fun TopBarOrganismNoTitlePreview() {
    TopBarOrganism(
        title = null,
        onNavigationBackClicked = {},
        actions = {
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null
                )
            }
        }
    )
}

@Preview
@Composable
private fun TopBarOrganismNormalPreview() {
    TopBarOrganism(
        title = "Livro XPTO",
        onNavigationBackClicked = {},
        actions = {
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null
                )
            }
        }
    )
}

@Preview
@Composable
private fun TopBarOrganismNoActionsPreview() {
    TopBarOrganism(
        title = "Livro XPTO",
        onNavigationBackClicked = null
    )
}
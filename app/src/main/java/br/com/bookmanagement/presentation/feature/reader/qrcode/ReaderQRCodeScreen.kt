package br.com.bookmanagement.presentation.feature.reader.qrcode

import android.Manifest
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalGetImage::class)
@Composable
fun ReaderQRCodeScreen(
    navController: NavController,
    viewModel: ReaderQRCodeViewModel = koinViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    when (state) {
        is QRCodeUiState.Success -> {
            val data = (state as QRCodeUiState.Success).item
            if (data.items.isNotEmpty()) {
                Text(text = data.items[0].volumeInfo.description)
            }
        }

        is QRCodeUiState.Error -> {

        }

        is QRCodeUiState.Loading -> {

        }

        is QRCodeUiState.OpenQRCode -> {
            OpenQRCode(viewModel)
        }
    }

}

@kotlin.OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun OpenQRCode(viewModel: ReaderQRCodeViewModel) {


    var openQRCodeReader by remember {
        mutableStateOf(false)
    }

    var qrCodeResult by remember {
        mutableStateOf("")
    }

    var isQRCodeRead by remember {
        mutableStateOf(false)  // Controla se o QR Code já foi lido
    }

    val context = LocalContext.current

    //TODO fazer essas regras de permissão no clique do ícone de qrcode, para garantir
    // as permissões na home e não abrir uma tela branca na primeira vez
    val cameraPermission = rememberPermissionState(
        Manifest.permission.CAMERA
    )

    LaunchedEffect(Unit) {
        when {
            cameraPermission.status.shouldShowRationale -> {
                Toast.makeText(context, "Usuário negou permissão", Toast.LENGTH_SHORT).show()
            }

            !cameraPermission.status.isGranted -> {
                cameraPermission.launchPermissionRequest()
            }

            cameraPermission.status.isGranted -> {
                openQRCodeReader = true
                qrCodeResult = ""
            }
        }
    }
    //Até aqui

    if (openQRCodeReader) {
        QRCodeReader(
            hasCameraPermission = cameraPermission.status.isGranted,
            buttonText = "Ler QRCode"
        ) { result ->
            if (result.isNotEmpty() && result != qrCodeResult && !isQRCodeRead) {
                viewModel.fetchData(result)
                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()

                isQRCodeRead = true
                qrCodeResult = result
            }
        }
    }
}
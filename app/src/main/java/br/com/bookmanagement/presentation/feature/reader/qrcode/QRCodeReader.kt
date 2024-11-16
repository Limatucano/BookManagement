package br.com.bookmanagement.presentation.feature.reader.qrcode

import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlin.math.min

private const val SQUARE_SIZE = 0.8f
private const val TWO = 2

@ExperimentalGetImage
@Composable
fun QRCodeReader(
    modifier: Modifier = Modifier,
    hasCameraPermission: Boolean,
    buttonText: String? = null,
    onButtonClick: (() -> Unit)? = null,
    onFailure: ((Exception) -> Unit)? = null,
    onResult: (String) -> Unit,
) {
    val camera = remember { QRCodeCamera() }

    if (hasCameraPermission) {
        Box(modifier = modifier.fillMaxSize()) {
            camera.CameraPreview(
                onBarcodeScanned = onResult,
                onFailure = onFailure,
            )
            Canvas(
                modifier =
                Modifier
                    .fillMaxSize()
                    .graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
            ) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                val size = min(canvasWidth, canvasHeight) * SQUARE_SIZE

                val topLeftX = (canvasWidth - size) / TWO
                val topLeftY = (canvasHeight - size) / TWO

                val squareTopLeft = Offset(topLeftX, topLeftY)
                val squareSize = Size(size, size)

                drawRect(Color(0x99000000))

                // Draws the square in the middle
                drawRoundRect(
                    topLeft = squareTopLeft,
                    size = squareSize,
                    color = Color.Transparent,
                    blendMode = BlendMode.Clear,
                    cornerRadius = CornerRadius.Zero,
                )
            }
            buttonText?.let { text ->
                Column(
                    modifier =
                    Modifier
                        .align(Alignment.BottomCenter)
                        .padding(
                            16.dp,
                            36.dp,
                            36.dp,
                        ),
                ) {
                    Button(
                        onClick = { onButtonClick?.invoke() }
                    ) {
                        Text(text = text)
                    }
                }
            }
        }
    }
}
package com.publicttapp.testdevicescanner.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    surface = Color(0xFFF3F4F8),
    primary = Color(0xFFFFFFFF),
    onPrimary = Color(0xFFE5E9FC),
    onPrimaryContainer = Color(0xFF285FF6),
    onSecondaryContainer = Color(0xFF1C1C1C),
    onTertiaryContainer = Color(0xFF7D8088),
    error = Color(0xFFFF0000)
)

@Composable
fun TestDeviceScannerTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
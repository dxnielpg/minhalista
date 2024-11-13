package com.caju.minhalista.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = LightBlue,
    secondary = BlueAccent,
    surface = DarkBlue,
    onSurface = WhiteText,
    onPrimary = WhiteText,
    onSecondary = WhiteText
)

@Composable
fun MinhalistaTheme(
    darkTheme: Boolean = true, // Tema escuro como padrão
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}

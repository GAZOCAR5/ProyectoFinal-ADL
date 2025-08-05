package com.tesmiguegazocar.controlpaseosmascotas.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = AzulPrincipal,
    secondary = AzulClaro,
    background = FondoClaro,
    surface = FondoClaro,
    onPrimary = Blanco,
    onSecondary = AzulOscuro,
    onBackground = AzulOscuro,
    onSurface = AzulOscuro,
)

@Composable
fun PaseosTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}

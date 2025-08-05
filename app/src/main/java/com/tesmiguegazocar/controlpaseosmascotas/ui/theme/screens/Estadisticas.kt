package com.tesmiguegazocar.controlpaseosmascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun Estadisticas() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        EstadisticaItem("Ganado", "$0", Color(0xFF4CAF50), Modifier.weight(1f))
        EstadisticaItem("Pendiente", "$0", Color(0xFFFF9800), Modifier.weight(1f))
        EstadisticaItem("Total", "$0", Color(0xFF1976D2), Modifier.weight(1f))
    }
}

@Composable
fun EstadisticaItem(titulo: String, valor: String, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(titulo, style = MaterialTheme.typography.labelLarge)
            Text(valor, style = MaterialTheme.typography.headlineSmall, color = color)
        }
    }
}

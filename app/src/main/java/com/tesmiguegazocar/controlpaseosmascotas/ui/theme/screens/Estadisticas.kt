package com.tesmiguegazocar.controlpaseosmascotas.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tesmiguegazocar.controlpaseosmascotas.modelovista.ModeloVistaPaseos
import com.tesmiguegazocar.controlpaseosmascotas.utilidades.formatearDinero

@Composable
fun EstadisticasCard(viewModel: ModeloVistaPaseos) {
    val totalGanado by viewModel.totalGanado.collectAsState()
    val totalPendiente by viewModel.totalPendiente.collectAsState()
    val total = totalGanado + totalPendiente

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Resumen Financiero",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            EstadisticaItem(
                titulo = "Ganado",
                valor = formatearDinero(totalGanado),
                color = Color(0xFF1B5E20),
                icon = "💰"
            )
            EstadisticaItem(
                titulo = "Pendiente",
                valor = formatearDinero(totalPendiente),
                color = Color(0xFFF57C00),
                icon = "⏳"
            )
            EstadisticaItem(
                titulo = "Total",
                valor = formatearDinero(total),
                color = Color(0xFF0D47A1),
                icon = "📈"
            )
        }
    }
}

@Composable
fun EstadisticaItem(titulo: String, valor: String, color: Color, icon: String) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(120.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.15f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(icon, fontSize = MaterialTheme.typography.headlineMedium.fontSize)
            Text(
                text = titulo,
                style = MaterialTheme.typography.bodyMedium,
                color = color
            )
            Text(
                text = valor,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }
    }
}

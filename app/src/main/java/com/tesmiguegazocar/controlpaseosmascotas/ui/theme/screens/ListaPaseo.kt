package com.tesmiguegazocar.controlpaseosmascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Money
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tesmiguegazocar.controlpaseosmascotas.datos.EntidadPaseoMascota
import com.tesmiguegazocar.controlpaseosmascotas.utilidades.formatearDinero
import com.tesmiguegazocar.controlpaseosmascotas.modelovista.ModeloVistaPaseos

@Composable
fun ListaDePaseos(viewModel: ModeloVistaPaseos) {
    val paseos by viewModel.paseos.collectAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(paseos) { paseo ->
            TarjetaPaseo(paseo, viewModel)
        }
    }
}

@Composable
fun TarjetaPaseo(paseo: EntidadPaseoMascota, viewModel: ModeloVistaPaseos) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "${paseo.nombreMascota} • ${paseo.tipoMascota}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "👤 Cliente: ${paseo.nombreCliente}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "💵 Total: ${formatearDinero(paseo.montoTotal)}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = { viewModel.cambiarEstadoPago(paseo) },
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF388E3C)
                    )
                ) {
                    Icon(Icons.Default.Money, contentDescription = "Pagar", modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(if (paseo.estaPagado) "Marcar Pendiente" else "Marcar Pagado")
                }

                OutlinedButton(
                    onClick = { viewModel.eliminarPaseo(paseo) },
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFFD32F2F)
                    )
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Eliminar", modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Eliminar")
                }
            }
        }
    }
}

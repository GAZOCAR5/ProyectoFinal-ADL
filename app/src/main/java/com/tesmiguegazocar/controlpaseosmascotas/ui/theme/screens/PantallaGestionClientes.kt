package com.tesmiguegazocar.controlpaseosmascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tesmiguegazocar.controlpaseosmascotas.modelovista.ModeloVistaPaseos
import com.tesmiguegazocar.controlpaseosmascotas.datos.EntidadPaseoMascota
import com.tesmiguegazocar.controlpaseosmascotas.utilidades.formatearDinero
import com.tesmiguegazocar.controlpaseosmascotas.utilidades.formatearFecha
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun PantallaGestionClientes(viewModel: ModeloVistaPaseos) {
    val paseos by viewModel.paseos.collectAsState()

    val clientes = paseos.groupBy { it.nombreCliente }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            "👥 Gestión de Clientes",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(clientes.entries.toList()) { (cliente, paseosCliente) ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("👤 $cliente", style = MaterialTheme.typography.titleMedium)
                        Text("🐶 Paseos: ${paseosCliente.size}")
                        Text("💰 Total acumulado: ${formatearDinero(paseosCliente.sumOf { it.montoTotal })}")
                        Text("📅 Último paseo: ${formatearFecha(paseosCliente.maxByOrNull { it.fecha }?.fecha)}")
                    }
                }
            }
        }
    }
}




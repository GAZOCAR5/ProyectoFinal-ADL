package com.tesmiguegazocar.controlpaseosmascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class PaseoPlaceholder(
    val nombreMascota: String,
    val tipoMascota: String,
    val cliente: String,
    val total: String
)

@Composable
fun ListaDePaseosV2() {
    val paseos = remember {
        listOf(
            PaseoPlaceholder("Rocky", "Perro", "Ana", "$120"),
            PaseoPlaceholder("Miau", "Gato", "Carlos", "$90")
        )
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(paseos) { paseo ->
            TarjetaPaseoV2(paseo)
        }
    }
}

@Composable
fun TarjetaPaseoV2(paseo: PaseoPlaceholder) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text("${paseo.nombreMascota} • ${paseo.tipoMascota}")
            Text("Cliente: ${paseo.cliente}")
            Text("Total: ${paseo.total}")

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                TextButton(onClick = {}) {
                    Text("Marcar Pagado")
                }
                TextButton(onClick = {}) {
                    Text("Eliminar")
                }
            }
        }
    }
}

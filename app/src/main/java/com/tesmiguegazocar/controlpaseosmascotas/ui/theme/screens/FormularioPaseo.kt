package com.tesmiguegazocar.controlpaseosmascotas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tesmiguegazocar.controlpaseosmascotas.utilidades.formatearDinero
import com.tesmiguegazocar.controlpaseosmascotas.modelovista.ModeloVistaPaseos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioNuevo(viewModel: ModeloVistaPaseos, onPaseoAgregado: () -> Unit) {
    val nombreMascota by viewModel.nombreMascota.collectAsState()
    val tipoMascota by viewModel.tipoMascota.collectAsState()
    val nombreCliente by viewModel.nombreCliente.collectAsState()
    val duracionHoras by viewModel.duracionHoras.collectAsState()
    val tarifaPorHora by viewModel.tarifaPorHora.collectAsState()
    val notas by viewModel.notas.collectAsState()

    val tipos = listOf("Perro", "Gato", "Conejo", "Otro")
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Registrar nuevo paseo",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            OutlinedTextField(
                value = nombreMascota,
                onValueChange = viewModel::actualizarNombreMascota,
                label = { Text("Nombre de la mascota") },
                leadingIcon = { Icon(Icons.Default.Pets, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = tipoMascota,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tipo de mascota") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    tipos.forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                viewModel.actualizarTipoMascota(it)
                                expanded = false
                            }
                        )
                    }
                }
            }

            OutlinedTextField(
                value = nombreCliente,
                onValueChange = viewModel::actualizarNombreCliente,
                label = { Text("Nombre del cliente") },
                modifier = Modifier.fillMaxWidth()
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = duracionHoras,
                    onValueChange = viewModel::actualizarDuracionHoras,
                    label = { Text("Horas") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = tarifaPorHora,
                    onValueChange = viewModel::actualizarTarifaPorHora,
                    label = { Text("Tarifa") },
                    modifier = Modifier.weight(1f)
                )
            }

            if (duracionHoras.isNotEmpty() && tarifaPorHora.isNotEmpty()) {
                val total = viewModel.calcularMontoTotal()
                Text(
                    "Total: ${formatearDinero(total)}",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            OutlinedTextField(
                value = notas,
                onValueChange = viewModel::actualizarNotas,
                label = { Text("Notas adicionales") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    viewModel.agregarPaseo()
                    onPaseoAgregado()
                },
                enabled = viewModel.formularioEsValido(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Paseo")
            }
        }
    }
}

package com.tesmiguegazocar.controlpaseosmascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioNuevo() {
    val tiposMascotas = listOf("Perro", "Gato", "Conejo", "Otro")
    var tipoMascota by remember { mutableStateOf("") }
    var nombreMascota by remember { mutableStateOf("") }
    var nombreCliente by remember { mutableStateOf("") }
    var duracionHoras by remember { mutableStateOf("") }
    var tarifaPorHora by remember { mutableStateOf("") }
    var notas by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nombreMascota,
                onValueChange = { nombreMascota = it },
                label = { Text("Nombre de la mascota") },
                modifier = Modifier.fillMaxWidth()
            )

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    readOnly = true,
                    value = tipoMascota,
                    onValueChange = {},
                    label = { Text("Tipo de mascota") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    tiposMascotas.forEach { tipo ->
                        DropdownMenuItem(
                            text = { Text(tipo) },
                            onClick = {
                                tipoMascota = tipo
                                expanded = false
                            }
                        )
                    }
                }
            }

            OutlinedTextField(
                value = nombreCliente,
                onValueChange = { nombreCliente = it },
                label = { Text("Nombre del cliente") },
                modifier = Modifier.fillMaxWidth()
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = duracionHoras,
                    onValueChange = { duracionHoras = it },
                    label = { Text("Horas") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = tarifaPorHora,
                    onValueChange = { tarifaPorHora = it },
                    label = { Text("Tarifa/hora") },
                    modifier = Modifier.weight(1f)
                )
            }

            OutlinedTextField(
                value = notas,
                onValueChange = { notas = it },
                label = { Text("Notas (opcional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { /* guardar */ },
                enabled = true,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar Paseo")
            }
        }
    }
}

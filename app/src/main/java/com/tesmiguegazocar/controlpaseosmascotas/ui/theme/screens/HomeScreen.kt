package com.tesmiguegazocar.controlpaseosmascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var mostrandoFormulario by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Control de Paseos 🐾") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFE8F0FE)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { mostrandoFormulario = !mostrandoFormulario },
                containerColor = Color(0xFF1976D2),
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = if (mostrandoFormulario) Icons.Default.Close else Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Estadisticas()
            if (mostrandoFormulario) {
                FormularioNuevo()
            } else {
                Text("Aquí iría la lista de paseos")
            }
        }
    }
}

package com.tesmiguegazocar.controlpaseosmascotas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.People
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tesmiguegazocar.controlpaseosmascotas.modelovista.ModeloVistaPaseos
import com.tesmiguegazocar.controlpaseosmascotas.ui.components.EstadisticasCard
import com.tesmiguegazocar.controlpaseosmascotas.ui.theme.FondoClaro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ModeloVistaPaseos,
    onGoToClientes: () -> Unit
) {
    var mostrandoFormulario by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = FondoClaro,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("🐾 Control de Paseos") },
                actions = {
                    IconButton(onClick = onGoToClientes) {
                        Icon(
                            imageVector = Icons.Default.People,
                            contentDescription = "Gestión de Clientes"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { mostrandoFormulario = !mostrandoFormulario },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
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
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            if (mostrandoFormulario) {
                FormularioNuevo(viewModel) {
                    mostrandoFormulario = false
                }
            } else {
                ListaDePaseos(viewModel)
            }

            EstadisticasCard(viewModel)
        }
    }
}

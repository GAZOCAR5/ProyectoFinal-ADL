package com.tesmiguegazocar.controlpaseosmascotas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tesmiguegazocar.controlpaseosmascotas.modelovista.ModeloVistaPaseos
import com.tesmiguegazocar.controlpaseosmascotas.ui.screens.HomeScreen
import com.tesmiguegazocar.controlpaseosmascotas.ui.screens.PantallaGestionClientes

@Composable
fun NavigationGraph(
    navController: NavHostController,
    viewModel: ModeloVistaPaseos
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(viewModel = viewModel, onGoToClientes = {
                navController.navigate("clientes")
            })
        }
        composable("clientes") {
            PantallaGestionClientes(viewModel = viewModel)
        }
    }
}

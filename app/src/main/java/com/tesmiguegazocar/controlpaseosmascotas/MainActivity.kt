package com.tesmiguegazocar.controlpaseosmascotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.tesmiguegazocar.controlpaseosmascotas.datos.BaseDeDatosPaseos
import com.tesmiguegazocar.controlpaseosmascotas.modelovista.ModeloVistaPaseos
import com.tesmiguegazocar.controlpaseosmascotas.repositorio.RepositorioPaseosMascotas
import com.tesmiguegazocar.controlpaseosmascotas.ui.navigation.NavigationGraph
import com.tesmiguegazocar.controlpaseosmascotas.ui.screens.HomeScreen
import com.tesmiguegazocar.controlpaseosmascotas.ui.theme.ControlpaseosmascotasTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControlpaseosmascotasTheme {
                AppEntryPoint()
            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    val context = LocalContext.current
    val database = BaseDeDatosPaseos.obtenerBaseDeDatos(context)
    val repositorio = RepositorioPaseosMascotas(database.accesoDatosPaseos())

    val factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return ModeloVistaPaseos(repositorio) as T
        }
    }

    val viewModel: ModeloVistaPaseos = viewModel(factory = factory)

    val navController = rememberNavController()
    NavigationGraph(navController, viewModel)
}

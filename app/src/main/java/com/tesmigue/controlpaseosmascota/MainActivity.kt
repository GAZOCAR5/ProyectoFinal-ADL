package com.tesmiguegazocar.controlpaseosmascotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tesmiguegazocar.controlpaseosmascotas.ui.screens.HomeScreen
import com.tesmiguegazocar.controlpaseosmascotas.ui.theme.PaseosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaseosTheme {
                HomeScreen()
            }
        }
    }
}

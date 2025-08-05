package com.tesmiguegazocar.controlpaseosmascotas.utilidades

import java.text.NumberFormat
import java.util.*

fun formatearDinero(cantidad: Double): String {
    val formato = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
    return formato.format(cantidad)
}

package com.tesmiguegazocar.controlpaseosmascotas.utilidades

import java.text.SimpleDateFormat
import java.util.*

fun formatearFecha(fecha: Date?): String {
    if (fecha == null) return "-"
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("es", "CL"))
    return sdf.format(fecha)
}

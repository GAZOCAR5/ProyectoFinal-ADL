package com.tesmiguegazocar.controlpaseosmascotas.repositorio

import com.tesmiguegazocar.controlpaseosmascotas.datos.AccesoDatosPaseos
import com.tesmiguegazocar.controlpaseosmascotas.datos.EntidadPaseoMascota
import kotlinx.coroutines.flow.Flow

// El repositorio es como un organizador que maneja todos los datos
// Es el intermediario entre la interfaz de usuario y la base de datos
class RepositorioPaseosMascotas(private val accesoDatosPaseos: AccesoDatosPaseos) {

    // Obtener todos los paseos de la base de datos
    fun todospaseos(): Flow<List<EntidadPaseoMascota>> {
        return accesoDatosPaseos.todospaseos()
    }

    // Obtener solo los paseos que no han sido pagados
    fun paseospendientes(): Flow<List<EntidadPaseoMascota>> {
        return accesoDatosPaseos.paseospendientes()
    }

    // Obtener solo los paseos que ya fueron pagados
    fun paseospagados(): Flow<List<EntidadPaseoMascota>> {
        return accesoDatosPaseos.paseospagados()
    }

    // Agregar un nuevo paseo a la base de datos
    suspend fun agregarPaseo(paseo: EntidadPaseoMascota) {
        accesoDatosPaseos.insertarPaseo(paseo)
    }

    // Actualizar un paseo (por ejemplo, marcarlo como pagado)
    suspend fun actualizarPaseo(paseo: EntidadPaseoMascota) {
        accesoDatosPaseos.actualizarPaseo(paseo)
    }

    // Eliminar un paseo de la base de datos
    suspend fun eliminarPaseo(paseo: EntidadPaseoMascota) {
        accesoDatosPaseos.eliminarPaseo(paseo)
    }

    // Obtener el total de dinero ganado (paseos pagados)
    fun obtenerTotalGanado(): Flow<Double?> {
        return accesoDatosPaseos.obtenerTotalGanado()
    }

    // Obtener el total de dinero pendiente (paseos no pagados)
    fun obtenerTotalPendiente(): Flow<Double?> {
        return accesoDatosPaseos.obtenerTotalPendiente()
    }
}
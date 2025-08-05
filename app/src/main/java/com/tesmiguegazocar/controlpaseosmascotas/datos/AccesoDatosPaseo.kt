package com.tesmiguegazocar.controlpaseosmascotas.datos

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AccesoDatosPaseos {
    @Query("SELECT * FROM paseos_mascotas WHERE estaPagado = 1 ORDER BY fecha DESC")
    fun paseospagados(): Flow<List<EntidadPaseoMascota>>
    @Query("SELECT * FROM paseos_mascotas WHERE estaPagado = 0 ORDER BY fecha DESC")
    fun paseospendientes(): Flow<List<EntidadPaseoMascota>>
    @Query("SELECT * FROM paseos_mascotas ORDER BY fecha DESC")
    fun todospaseos(): Flow<List<EntidadPaseoMascota>>

    // Agregar un nuevo paseo a la base de datos
    @Insert
    suspend fun insertarPaseo(paseo: EntidadPaseoMascota)

    // Actualizar un paseo existente (por ejemplo, marcarlo como pagado)
    @Update
    suspend fun actualizarPaseo(paseo: EntidadPaseoMascota)

    // Eliminar un paseo de la base de datos
    @Delete
    suspend fun eliminarPaseo(paseo: EntidadPaseoMascota)

    // Calcular total de dinero ganado (solo paseos que ya fueron pagados)
    @Query("SELECT SUM(montoTotal) FROM paseos_mascotas WHERE estaPagado = 1")
    fun obtenerTotalGanado(): Flow<Double?>

    // Calcular dinero pendiente de cobro (paseos no pagados)
    @Query("SELECT SUM(montoTotal) FROM paseos_mascotas WHERE estaPagado = 0")
    fun obtenerTotalPendiente(): Flow<Double?>
}
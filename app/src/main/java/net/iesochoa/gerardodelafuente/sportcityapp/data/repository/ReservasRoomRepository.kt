package net.iesochoa.gerardodelafuente.sportcityapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import net.iesochoa.gerardodelafuente.sportcityapp.data.local.ReservaDao
import net.iesochoa.gerardodelafuente.sportcityapp.data.local.ReservaEntity
import net.iesochoa.gerardodelafuente.sportcityapp.data.local.toDomain
import net.iesochoa.gerardodelafuente.sportcityapp.data.local.toEntity
import net.iesochoa.gerardodelafuente.sportcityapp.model.Reserva

class ReservasRoomRepository(
    private val reservaDao: ReservaDao
) {
    val reservas: Flow<List<Reserva>> =
        reservaDao.getAllReservas().map { listaEntities ->
            listaEntities.map { it.toDomain() }
        }

    // Insertar una reserva nueva
    suspend fun addReserva(reserva: Reserva) {
        reservaDao.insertReserva(reserva.toEntity())
    }

    // borrar?
    suspend fun deleteAll() {
        reservaDao.deleteAll()
    }



}



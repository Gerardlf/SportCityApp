package net.iesochoa.gerardodelafuente.sportcityapp.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iesochoa.gerardodelafuente.sportcityapp.model.Reserva

object FakeReservasRepository {


    // 1) Lista de reservas interna privadd
    private val _reservas = MutableStateFlow<List<Reserva>>(emptyList())
    val reservas: StateFlow<List<Reserva>> = _reservas.asStateFlow()

    // 2) Contador para generar identidatdes
    private var nextId = 1

    // 3) funcion Añadir una reserva nueva


    fun addReserva(reserva: Reserva) {
        val nuevaReserva = reserva.copy(id = nextId)
        nextId++

        _reservas.update { listaActual ->
            listaActual + nuevaReserva
        }
    }




}
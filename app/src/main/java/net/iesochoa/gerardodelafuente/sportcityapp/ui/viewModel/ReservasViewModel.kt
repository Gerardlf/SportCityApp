package net.iesochoa.gerardodelafuente.sportcityapp.ui.viewModel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iesochoa.gerardodelafuente.sportcityapp.data.FakeReservasRepository
import net.iesochoa.gerardodelafuente.sportcityapp.model.Reserva
import net.iesochoa.gerardodelafuente.sportcityapp.model.ReservasUiState

class ReservasViewModel : ViewModel() {
    private val reservasRepository = FakeReservasRepository

    private val _uiState = MutableStateFlow(ReservasUiState())
    val uiState: StateFlow<ReservasUiState> = _uiState.asStateFlow()

    // Al iniciar, cojo el repo vacio
    init {

        val listaInicial = reservasRepository.reservas.value
        _uiState.value = ReservasUiState(reservas = listaInicial)
    }

    //Crear una reserva nueva
    fun crearReserva(
        pistaId: Int,
        pistaNombre: String,
        fecha: String,
        hora: String,
        nombreCliente: String,
        telefonoCliente: String,
        comentario: String?,
        deporte: String
    ) {
        val reserva = Reserva(
            id = 0,
            pistaId = pistaId,
            pistaNombre = pistaNombre,
            fecha = fecha,
            hora = hora,
            nombreCliente = nombreCliente,
            telefonoCliente = telefonoCliente,
            comentario = comentario,
            deporte = deporte
        )

        //añado reserva
        reservasRepository.addReserva(reserva)

        //actualizamos

        val listaActualizada = reservasRepository.reservas.value
        _uiState.update { current ->
            current.copy(reservas = listaActualizada)

        }


    }
}
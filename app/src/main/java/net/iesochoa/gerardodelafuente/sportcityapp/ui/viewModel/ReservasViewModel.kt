package net.iesochoa.gerardodelafuente.sportcityapp.ui.viewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.iesochoa.gerardodelafuente.sportcityapp.SportCityApp
import net.iesochoa.gerardodelafuente.sportcityapp.data.FakeReservasRepository
import net.iesochoa.gerardodelafuente.sportcityapp.data.repository.ReservasRoomRepository
import net.iesochoa.gerardodelafuente.sportcityapp.model.Reserva
import net.iesochoa.gerardodelafuente.sportcityapp.model.ReservasUiState

class ReservasViewModel(
    application: Application
) : AndroidViewModel(application)
{
    private val reservasRepository: ReservasRoomRepository =
        (application as SportCityApp).reservasRoomRepository

    private val _uiState = MutableStateFlow(ReservasUiState())
    val uiState: StateFlow<ReservasUiState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            reservasRepository.reservas.collect { lista->
                _uiState.update { actual ->
                    actual.copy( reservas =  lista)
                }
            }
        }
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
        viewModelScope.launch {
            reservasRepository.addReserva(reserva)
        }




    }
}
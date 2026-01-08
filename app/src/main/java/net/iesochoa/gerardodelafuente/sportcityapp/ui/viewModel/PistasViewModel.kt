package net.iesochoa.gerardodelafuente.sportcityapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import net.iesochoa.gerardodelafuente.sportcityapp.model.PistasUistate
import net.iesochoa.gerardodelafuente.sportcityapp.data.FakePistasRepository
import net.iesochoa.gerardodelafuente.sportcityapp.data.PistasRepository

class PistasViewModel(
    private val repositorio: PistasRepository = FakePistasRepository()
) : ViewModel() {


    private val _uiState = MutableStateFlow(PistasUistate())
    val uiState: StateFlow<PistasUistate> = _uiState.asStateFlow()

    init {
        cargarPistasTenis()
    }

    //funcion para cargar pistas
    private fun cargarPistasTenis() {
        viewModelScope.launch {

            //cargando
            _uiState.update { estadoActual ->
                estadoActual.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            try {
                //Obtengo las pistas de tenis del repositorio
                val pistasRepo = repositorio.getPistasTenis()

                _uiState.update { estadoActual ->
                    estadoActual.copy(
                        isLoading = false,
                        pistas = pistasRepo
                    )
                }
            } catch (excepcion: Exception) {

                //si hay error
                _uiState.update { estadoActual ->
                    estadoActual.copy(
                        isLoading = false,
                        errorMessage = "Error al cargar las pistas"
                    )
                }
            }
        }
    }

}
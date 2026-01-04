package net.iesochoa.gerardodelafuente.sportcityapp.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iesochoa.gerardodelafuente.sportcityapp.data.LoginUiState

class LoginViewModel: ViewModel() {


    // Estado privado solo modificable aqui
    private val _uiState = MutableStateFlow(LoginUiState())

    // Estado expuesto
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    // cambio de correo en el textfield
    fun onEmailChanged(newEmail: String) {
        _uiState.update { current ->
            current.copy(email = newEmail)
        }
    }

    //  cambiode la contraseña
    fun onPasswordChanged(newPassword: String) {
        _uiState.update { current ->
            current.copy(password = newPassword)
        }
    }

    //  pulsa "Iniciar sesión"


    fun onLoginClicked() {
        //Todo!!!!!!!!!!!!!!!!
        // val email = _uiState.value.email
        // val password = _uiState.value.password
    }
}

package net.iesochoa.gerardodelafuente.sportcityapp.ui.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iesochoa.gerardodelafuente.sportcityapp.data.auth.AuthRepository
import net.iesochoa.gerardodelafuente.sportcityapp.model.LoginUiState


//View model para el login
class LoginViewModel(private val authRepository: AuthRepository = AuthRepository()) : ViewModel() {


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
        val current = uiState.value

        var emailError: String? = null
        var passwordError: String? = null

        //Valido campos mail y password
        if (current.email.isBlank()) {
            emailError = "El email es obligatorio"
        }
        if (current.password.isBlank()) {
            passwordError = "La contraseña es obligatoria"
        }

        //Actualizo errores en los campos, limpio errorauth

        _uiState.update { estado ->
            estado.copy(
                emailError = emailError,
                passwordError = passwordError,
                authenError = null,
                isloggedIn = false
            )
        }
        //si tenemos algun error:
        if (emailError != null || passwordError != null) {
            return
        }
        //si noy error isloagina true
        _uiState.update { estado ->
            estado.copy(
                isloading = true,
                authenError = null
            )
        }

        //si todo bien se llama al repo para hacer el ligin en firebase
        authRepository.login(
            email = current.email,
            password = current.password){
            isSuccess, errorMessage ->
            if (isSuccess){
                //login es correcto
                _uiState.update { estado ->
                    estado.copy(
                        isloading = false,
                        authenError = null,
                        isloggedIn = true
                    )
                }
            }
            else{
                //error en el login en firebase:
                _uiState.update { estado->
                    estado.copy(
                        isloading = false,
                        authenError = errorMessage ?: "Error al iniciar sesión",
                        isloggedIn = false,
                    )
                }
            }
        }
    }
}

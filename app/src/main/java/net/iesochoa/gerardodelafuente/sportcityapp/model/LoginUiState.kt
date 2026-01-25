package net.iesochoa.gerardodelafuente.sportcityapp.model

import androidx.credentials.provider.AuthenticationError

data class LoginUiState(
    val email: String = "",
    val password: String = "",

    //Errores en mail y password
    val emailError: String? = null,
    val passwordError: String? = null,

    //estado autenticacion
    val isloading: Boolean = false,
    val authenError: String? = null,
    val isloggedIn: Boolean = false
)
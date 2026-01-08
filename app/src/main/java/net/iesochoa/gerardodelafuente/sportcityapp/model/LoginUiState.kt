package net.iesochoa.gerardodelafuente.sportcityapp.model

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError:String?=null
)
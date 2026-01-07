package net.iesochoa.gerardodelafuente.sportcityapp.Model

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError:String?=null
)
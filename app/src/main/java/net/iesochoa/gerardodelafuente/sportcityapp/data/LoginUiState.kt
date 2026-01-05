package net.iesochoa.gerardodelafuente.sportcityapp.data

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError:String?=null
)
package net.iesochoa.gerardodelafuente.sportcityapp.Model

data class PistasUistate(

val isLoading: Boolean = false,
val pistas: List<Pista> = emptyList(),
val errorMessage: String? = null)
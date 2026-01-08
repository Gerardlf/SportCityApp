package net.iesochoa.gerardodelafuente.sportcityapp.model

data class PistasUistate(

val isLoading: Boolean = false,
val pistas: List<Pista> = emptyList(),
val errorMessage: String? = null)
package net.iesochoa.gerardodelafuente.sportcityapp.model
//Data class del estado de la pista
data class PistasUistate(

val isLoading: Boolean = false,
val pistas: List<Pista> = emptyList(),
val errorMessage: String? = null)
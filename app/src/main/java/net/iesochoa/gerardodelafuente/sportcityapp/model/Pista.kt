package net.iesochoa.gerardodelafuente.sportcityapp.model

data class Pista(
    val id: Int,
    val nombre: String,
    val deporte: String,
    val precioHora: Double,
    val descripcion: String = ""
)
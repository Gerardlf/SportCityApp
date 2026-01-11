package net.iesochoa.gerardodelafuente.sportcityapp.model

data class Reserva(

    val id: Int,
    val pistaId: Int,
    val pistaNombre: String,
    val fecha: String,
    val hora: String,
    val nombreCliente: String,
    val telefonoCliente: String,
    val comentario: String? = null
)
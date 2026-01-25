package net.iesochoa.gerardodelafuente.sportcityapp.data.local

import net.iesochoa.gerardodelafuente.sportcityapp.model.Pista

fun PistaEntity.toDomain(): Pista {
    return Pista(
        id = this.id,
        nombre = this.nombre,
        deporte = this.deporte,
        precioHora = this.precioHora
    )
}

// De modelo de dominio a Entity para guardar en la base de datos
fun Pista.toEntity(): PistaEntity {
    return PistaEntity(
        id = this.id,
        nombre = this.nombre,
        deporte = this.deporte,
        precioHora = this.precioHora

    )
}
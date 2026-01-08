package net.iesochoa.gerardodelafuente.sportcityapp.data

import net.iesochoa.gerardodelafuente.sportcityapp.Model.Pista

class FakePistasRepository : PistasRepository {
    override suspend fun getPistasTenis(): List<Pista> {
        return listOf(
            Pista(
                id = 1,
                nombre = "Pista tenis 1",
                tipo = "Cubierta",
                precioHora = 20.0
            ),
            Pista(
                id = 2,
                nombre = "Pista tenis 2",
                tipo = "Exterior",
                precioHora = 18.0
            ),
            Pista(
                id = 3,
                nombre = "Pista tenis 3",
                tipo = "Cubierta",
                precioHora = 19.0
            )
        )
    }
}
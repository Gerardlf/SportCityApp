package net.iesochoa.gerardodelafuente.sportcityapp.data

import net.iesochoa.gerardodelafuente.sportcityapp.model.Pista

//Repo fake para ir probando la app
interface PistasRepository {
    suspend fun getPistasTenis():List<Pista>
}
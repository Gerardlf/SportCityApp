package net.iesochoa.gerardodelafuente.sportcityapp.data

import net.iesochoa.gerardodelafuente.sportcityapp.Model.Pista

interface PistasRepository {
    suspend fun getPistasTenis():List<Pista>
}
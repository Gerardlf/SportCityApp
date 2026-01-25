package net.iesochoa.gerardodelafuente.sportcityapp.data.repository

import net.iesochoa.gerardodelafuente.sportcityapp.data.local.PistaDao
import net.iesochoa.gerardodelafuente.sportcityapp.data.local.toDomain
import net.iesochoa.gerardodelafuente.sportcityapp.data.local.toEntity
import net.iesochoa.gerardodelafuente.sportcityapp.model.Pista

class PistasRoomRepository(
    private val pistasDao: PistaDao
) {
    //obtener todas las pistas
    suspend fun getAllPistas(): List<Pista>{
        val entities = pistasDao.getAllPistas()
        return entities.map { it.toDomain() }
    }

    //Obtener pistas por deporte
    suspend fun  getPistasByDeporte(deporte: String): List<Pista>{
        val entities = pistasDao.getPistasByDeporte(deporte)
        return entities.map { it.toDomain() }
    }
    // obtener pista por id
    suspend fun getPistaById(id: Int):Pista?{
        val entity = pistasDao.getPistaById(id)
        return entity?.toDomain()
    }

    suspend fun insertPistas(pistas:List<Pista>){
        val entities = pistas.map { it.toEntity() }
        pistasDao.insertPistas(entities)
    }

}
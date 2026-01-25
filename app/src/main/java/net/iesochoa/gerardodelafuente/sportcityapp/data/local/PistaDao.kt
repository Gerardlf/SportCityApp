package net.iesochoa.gerardodelafuente.sportcityapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PistaDao {

    //para obtener todas las pistas
    @Query("SELECT * FROM pistas")
    suspend fun getAllPistas(): List<PistaEntity>

    //para obtener una pista por id
    @Query("SELECT * FROM pistas WHERE id = :id")
    suspend fun getPistaById (id: Int): PistaEntity?

    //Para obtener pistas filtrando el tipo
    @Query("SELECT * FROM pistas WHERE deporte = :deporte")
    suspend fun getPistasByDeporte(deporte: String): List<PistaEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPistas(pistas: List<PistaEntity>)
}
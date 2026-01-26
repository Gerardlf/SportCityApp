package net.iesochoa.gerardodelafuente.sportcityapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.OnConflictStrategy


@Dao
interface ReservaDao {

    //Todas las reservas
    @Query("SELECT * FROM reservas ORDER BY id DESC")
    fun getAllReservas(): Flow<List<ReservaEntity>>

    //Insertar una reserva nueva
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReserva(reserva: ReservaEntity)


    //posiblemente si me da tiempo
    @Query("DELETE FROM reservas")
    suspend fun deleteAll()


}
package net.iesochoa.gerardodelafuente.sportcityapp.data.local

import androidx.room.Dao
import androidx.room.Delete
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
    @Delete
    suspend fun deleteReserva(reserva: ReservaEntity)

}
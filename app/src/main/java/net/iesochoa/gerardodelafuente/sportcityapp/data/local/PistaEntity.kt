package net.iesochoa.gerardodelafuente.sportcityapp.data.local
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "pistas")

data class PistaEntity(
    @PrimaryKey(autoGenerate=true)
    val id: Int = 0,
    val nombre: String,
    val deporte: String,
    val precioHora: Double,

)
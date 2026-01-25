package net.iesochoa.gerardodelafuente.sportcityapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [PistaEntity::class, ReservaEntity::class],
    version= 2,
    exportSchema = false
)
abstract class SportCityDataBase: RoomDatabase() {

    //DAO
    abstract fun pistaDao(): PistaDao
    abstract fun reservaDao(): ReservaDao

    companion object{
        @Volatile
        private var INSTANCE : SportCityDataBase?=null

        fun getDatabase(context: Context): SportCityDataBase{
            return INSTANCE ?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    SportCityDataBase::class.java,
                    "sportcity_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
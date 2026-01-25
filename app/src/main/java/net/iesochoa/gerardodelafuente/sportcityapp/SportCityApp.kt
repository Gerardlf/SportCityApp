package net.iesochoa.gerardodelafuente.sportcityapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import net.iesochoa.gerardodelafuente.sportcityapp.data.local.SportCityDataBase
import net.iesochoa.gerardodelafuente.sportcityapp.data.repository.PistasRoomRepository
import net.iesochoa.gerardodelafuente.sportcityapp.model.Pista

class SportCityApp : Application() {

    //Base de datos room
    val database by lazy {
        SportCityDataBase.getDatabase(this)
    }

    //repositorio de pistas
    val pistasRoomRepository by lazy {
        PistasRoomRepository(database.pistaDao())
    }

    private val applicationScope = CoroutineScope(SupervisorJob()+ Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        cargarPistas()
    }

    private fun cargarPistas(){
        applicationScope.launch {
            val existentes = pistasRoomRepository.getAllPistas()

            if (existentes.isEmpty()) {

                val pistasDemo = listOf(
                    Pista(
                        id = 1,
                        nombre = "Pista Central",
                        deporte = "tenis",
                        precioHora = 15.0
                    ),
                    Pista(
                        id = 2,
                        nombre = "Pista Exterior 1",
                        deporte = "tenis",
                        precioHora = 12.0
                    ),
                    Pista(
                        id = 3,
                        nombre = "Pista Exterior 2",
                        deporte = "tenis",
                        precioHora = 12.0
                    ),
                    Pista(
                        id = 4,
                        nombre = "Pista Exterior 3",
                        deporte = "tenis",
                        precioHora = 10.0
                    )
                )

                // Inseertto las pistas en room
                pistasRoomRepository.insertPistas(pistasDemo)
            }
        }
    }




}
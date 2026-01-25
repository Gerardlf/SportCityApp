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

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        cargarPistas()
    }

    private fun cargarPistas() {
        applicationScope.launch {
            val existentes = pistasRoomRepository.getAllPistas()

            if (existentes.isEmpty()) {

                val pistasDemo = listOf(
                    Pista(
                        id = 1,
                        nombre = "Pista Central",
                        deporte = "tenis",
                        precioHora = 15.0,
                        descripcion = "Pista central con mayor amplitud y grada cercana. Recomendada para partidos de nivel medio/alto. ideal para partidos entre amigos. Buen estado de superficie y luz suficiente para jugar por la tarde."
                    ),
                    Pista(
                        id = 2,
                        nombre = "Pista Exterior 1",
                        deporte = "tenis",
                        precioHora = 12.0,
                        descripcion = "Pista de tenis de alta calidad, diseñada para ofrecer una experiencia de juego óptima tanto a nivel amateur como profesional. Superficie cuidada, iluminación adecuada y entorno tranquilo para que cada partido se disfrute al máximo."
                    ),
                    Pista(
                        id = 3,
                        nombre = "Pista Exterior 2",
                        deporte = "tenis",
                        precioHora = 12.0,
                        descripcion = "Pista central con mayor amplitud y grada cercana. Recomendada para partidos de nivel medio/alto. Superficie cuidada, iluminación adecuada y entorno tranquilo para que cada partido se disfrute al máximo.",

                    ),
                    Pista(
                        id = 4,
                        nombre = "Pista Exterior 3",
                        deporte = "tenis",
                        precioHora = 10.0,
                        descripcion = "Pista rápida con mayor amplitud y grada cercana. Recomendada para partidos de nivel medio/alto."
                    )
                )

                // Inseertto las pistas en room
                pistasRoomRepository.insertPistas(pistasDemo)
            }
        }
    }


}
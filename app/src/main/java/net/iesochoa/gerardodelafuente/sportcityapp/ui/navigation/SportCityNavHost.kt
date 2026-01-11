package net.iesochoa.gerardodelafuente.sportcityapp.ui.navigation

import android.app.FragmentManager
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.ConfirmacionReservaScreen
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.DetallePistaScreen
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.HomeScreen
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.MisReservasScreen
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.PistasTennisScreen
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.ReservaFormScreen
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.loginScreen

@Composable
fun SportCityNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenNavigation.Login.route
    ) {
        //pantalla de login
        composable(route = ScreenNavigation.Login.route) {
            loginScreen(navController = navController)
        }

        //Pantalla home
        composable(route = ScreenNavigation.Home.route) {
            HomeScreen(navController = navController)
        }

        //pantalla pistas de tenis
        composable(route = ScreenNavigation.PistasTenis.route) {
            PistasTennisScreen(navController = navController)
        }
        //pantalla detallePista
        composable(
            route = ScreenNavigation.DetallePista.route, arguments = listOf(
                navArgument("pistaId") {
                    type = NavType.IntType
                }
            )) { backStackEntry ->
            val pistaId = backStackEntry.arguments?.getInt("pistaId") ?: -1

            DetallePistaScreen(
                navController = navController,
                pistaId = pistaId
            )

        }

        //pantalla formulario
        composable(
            route = ScreenNavigation.ReservaForm.route,
            arguments = listOf(
                navArgument("pistaId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val pistaId = backStackEntry.arguments?.getInt("pistaId") ?: -1

            ReservaFormScreen(
                navController = navController,
                pistaId = pistaId,
            )
        }

        //pantalla mis reservas

        composable(
            ScreenNavigation.MisReservas.route
        ) {
            MisReservasScreen(navController = navController)
        }


        //pantalla confirmacion reserva

        composable(
            route = ScreenNavigation.ConfirmacionReserva.route,
            arguments = listOf(
                navArgument("deporte") { type = NavType.StringType },
                navArgument("pistaNombre") { type = NavType.StringType },
                navArgument("hora") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val deporte = backStackEntry.arguments?.getString("deporte") ?: ""
            val pistaNombre = backStackEntry.arguments?.getString("pistaNombre") ?: ""
            val hora = backStackEntry.arguments?.getString("hora") ?: ""

            ConfirmacionReservaScreen(
                navController = navController,
                deporte = deporte,
                pistaNombre = pistaNombre,
                hora = hora
            )
        }


    }

}
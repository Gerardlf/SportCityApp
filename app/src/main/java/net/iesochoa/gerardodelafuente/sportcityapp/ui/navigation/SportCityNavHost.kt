package net.iesochoa.gerardodelafuente.sportcityapp.ui.navigation

import android.app.FragmentManager
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.DetallePistaScreen
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.HomeScreen
import net.iesochoa.gerardodelafuente.sportcityapp.ui.screens.PistasTennisScreen
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
        composable(route = ScreenNavigation.DetallePista.route, arguments = listOf(
            navArgument("pistaId"){
                type= NavType.IntType
            }
        )){
            backStackEntry ->
            val pistaId=backStackEntry.arguments?.getInt("pistaId") ?: -1

            DetallePistaScreen(
                navController = navController,
                pistaId=pistaId
            )

        }


        composable(
            route = ScreenNavigation.ReservaForm.route,
            arguments = listOf(
                navArgument("pistaId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val pistaId = backStackEntry.arguments?.getInt("pistaId") ?: -1

            ReservaFormScreen(
                navController = navController,
                pistaId = pistaId
            )
        }



    }

}
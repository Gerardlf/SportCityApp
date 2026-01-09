package net.iesochoa.gerardodelafuente.sportcityapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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


    }

}
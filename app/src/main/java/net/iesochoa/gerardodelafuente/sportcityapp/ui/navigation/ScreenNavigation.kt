package net.iesochoa.gerardodelafuente.sportcityapp.ui.navigation

//clase para la navegacion (sellada) cada pantalla de la aplicacion

sealed class ScreenNavigation(val route: String){

    //pantalla login
    object Login: ScreenNavigation("login")

    //pantalla inicio(con todos los depostes de sportcity)
    object Home: ScreenNavigation("home")

    //pantalla de listado de pistas de tenis
    object PistasTenis: ScreenNavigation("pistas_tenis")




}
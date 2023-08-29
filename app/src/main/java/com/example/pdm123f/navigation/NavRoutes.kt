package com.example.pdm123f.navigation

sealed class NavRoutes(val route: String) {
    /**
     * Esta clase sellada es para las rutas de la barra de navegación
     */
    object FirstPartial: NavRoutes("firstPartial")
    object SecondPartial: NavRoutes("secondPartial")
    object ThirdPartial: NavRoutes("thirdPartial")
    object PadelScore: NavRoutes("padelScore")
    object EvenOdd: NavRoutes("evenorodd")

}
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
    object Cards: NavRoutes("cards")
    object Compare: NavRoutes("compare")
    object Barber: NavRoutes("barber")
    object Apple: NavRoutes("apple")
    object Listas: NavRoutes("listas")
    object Qr: NavRoutes("qr")

}
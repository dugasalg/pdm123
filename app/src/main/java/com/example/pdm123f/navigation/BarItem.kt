package com.example.pdm123f.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Esta es una clase de datos para los elementos de la barra de navegación
 */

data class BarItem(
    // Titulo de la opción
    val title: Int,
    //Icono de la opción
    val image: ImageVector,
    //Ruta a la cual se dirige la opción
    val route: String
)

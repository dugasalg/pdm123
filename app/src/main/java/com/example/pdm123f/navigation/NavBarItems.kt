package com.example.pdm123f.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TrendingUp
import com.example.pdm123f.R

object NavBarItems {
    val NavBarItems = listOf(
        BarItem(
            title = R.string.first_partial,
            image = Icons.Filled.Home,
            route = "firstPartial"
        ),
        BarItem(
            title = R.string.second_partial,
            image = Icons.Filled.TrendingUp,
            route = "secondPartial"
        ),
        BarItem(
            title = R.string.third_partial,
            image = Icons.Filled.Star,
            route = "thirdPartial"
        ),

        )
}
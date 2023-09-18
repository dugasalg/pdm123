package com.example.pdm123f

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.pdm123f.navigation.NavRoutes

@Composable
fun FirstPartialView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

        ) {
        Text(
            text = stringResource(id = R.string.first_partial),
            color = MaterialTheme.colors.secondary
        )
        Button(onClick = { navController.navigate(route = "padelScore") }) {
            Text(text = stringResource(id = R.string.padel_score))
        }

        Button(onClick = { navController.navigate(route = "evenorodd") }) {
            Text(text = stringResource(id = R.string.even_odd))
        }

        Button(onClick = { navController.navigate(route = "cards") }) {
            Text(text = stringResource(id = R.string.cards))
        }

        Button(onClick = { navController.navigate(route = "barber") }) {
            Text(text = stringResource(id = R.string.barber))
        }
        Button(onClick = { navController.navigate(route = "apple") }) {
            Text(text = stringResource(id = R.string.apple))
        }
    }
}

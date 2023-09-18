package com.example.pdm123f.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdm123f.R

@Composable
fun CardsView(navController: NavController, viewModel: CardsViewModel) {
    // Observa la imagen actual obtenida del ViewModel
    val card by viewModel.getRandomImage().observeAsState(R.drawable.back)

    // Diseño de la pantalla en una columna
    Column {
        Image(painter = painterResource(id = card), contentDescription = "",
            modifier = androidx.compose.ui.Modifier
                .width(450.dp)
                .height(450.dp)


        )
        // Botones en una fila
        Row {
            Button(onClick = { viewModel.showBackCard()}) {
                Text(text = stringResource(id = R.string.hide))
            }
            Button(onClick = { viewModel.getRandomCard()}) {
                Text(text = stringResource(id = R.string.get_card))
            }
        }
    }

}

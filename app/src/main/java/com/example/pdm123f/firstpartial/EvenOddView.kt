package com.example.pdm123f.firstpartial


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData

import androidx.navigation.NavController
import com.example.pdm123f.R
import com.example.pdm123f.ui.theme.utils.ComposeLottieEven
import com.example.pdm123f.ui.theme.utils.ComposeLottieOdd

@Composable
fun EvenOddView(navController: NavController, viewModel: EvenOrOddViewModel) {
    //// Esta variable va a almacenar el valor del TextField
    var txtNumber by remember { mutableStateOf("") }
    val evenOrOddStatus by viewModel.evenOrOddStatus.observeAsState("")

    // Diseño de la pantalla en una columna
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Muestra la animación "even" o "odd" según el estado
        if (viewModel.getBooleanState().value == true) {
            ComposeLottieEven(modifier = Modifier.width(300.dp).height(300.dp))
        } else {
            ComposeLottieOdd(modifier = Modifier.width(300.dp).height(300.dp))
        }
        Text(text = stringResource(id = R.string.even_odd))
        TextField(
            value = txtNumber,
            onValueChange = {
                txtNumber = it
                if (txtNumber != "") {
                    // Calcula si es par o impar cuando se ingresa un número
                    viewModel.calculateEvenOrOdd(txtNumber.toInt())
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = evenOrOddStatus)

    }
}


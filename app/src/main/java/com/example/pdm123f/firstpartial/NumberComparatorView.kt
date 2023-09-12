package com.example.pdm123f.firstpartial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.pdm123f.R


@Composable
fun NumberComparatorView(viewModel: NumberComparatorViewModel) {
    var number1 by remember { mutableStateOf("0") }
    var number2 by remember { mutableStateOf("0") }
    var number3 by remember { mutableStateOf("0") }
    val compareState by viewModel.getResult().observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = number1,
            onValueChange = { newValue -> number1 = newValue },
            label = { Text("Num 1") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = number2,
            onValueChange = { newValue -> number2 = newValue },
            label = { Text("Num 2") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = number3,
            onValueChange = { newValue -> number3 = newValue },
            label = { Text("Num 3") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                val num1 = number1.toInt()
                val num2 = number2.toInt()
                val num3 = number3.toInt()
                viewModel.compareNumbers(NumberComparator(num1, num2, num3))
            }
        ) {
            Text(R.string.compare.toString())
        }

        Text(text = compareState)
    }
}
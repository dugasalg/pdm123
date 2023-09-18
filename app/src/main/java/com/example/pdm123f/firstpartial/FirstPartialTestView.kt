package com.example.pdm123f.firstpartial

import ApplesViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.pdm123f.R
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import android.widget.Toast
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


@Composable
fun ApplesView(viewModel: ApplesViewModel) {
    val totalProdRes by viewModel.totalProduction
    val actualProdRes by viewModel.actualProduction
    val percentageRes by viewModel.percentage
    val context = LocalContext.current


    var totalProdTxt by remember { mutableStateOf(totalProdRes.toString()) }
    var actualProdTxt by remember { mutableStateOf(actualProdRes.toString()) }
    var percentageTxt by remember { mutableStateOf("0.0") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            // Modifica el color del fondo de la columna si el porcentaje es mayor a 70

            .background(if (percentageRes.toFloat() > 70.0f) Color.Red else Color.White), // Cambia el color de fondo aquí
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.apples),
                contentDescription = "Manzanas"
            )

            Spacer(
                modifier = Modifier
                    .width(9.dp)
                    .height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Produccion Total",
                modifier = Modifier.padding(15.dp)
            )

            TextField(
                value = viewModel.currentTotalProduction.value.toString(),
                onValueChange = { viewModel.currentTotalProduction.value = it.toIntOrNull() ?:0 },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.width(100.dp).height(49.dp)


            )


            Spacer(
                modifier = Modifier.width(15.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.apples),
                contentDescription = "Manzana",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clickable {
                        viewModel.calculateTotalProdToast(context)
                    }
            )

        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Produccion Actual",
                modifier = Modifier.padding(15.dp)
            )
            TextField(
                value = viewModel.currentActualProduction.value.toString(),
                onValueChange = {
                    viewModel.currentActualProduction.value = it.toIntOrNull() ?: 0
                },
                modifier = Modifier.width(100.dp).height(49.dp),
                enabled = false
            )
            Spacer(
                modifier = Modifier.width(50.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.apples),
                contentDescription = "Manzana",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clickable {
                        viewModel.calculateActualProdToast(context)
                    }
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.add5() },
            ) {
                Text(text = "+5")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add15() }) {
                Text(text = "+15")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add30() }) {
                Text(text = "+30")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { viewModel.add50() }) {
                Text(text = "+50")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Porcentaje",
                modifier = Modifier.padding(15.dp)
            )

// Modifica el color del texto y del fondo según el porcentaje
            val percentage = percentageRes.toFloat()
            val textColor = if (percentage > 80.0f) Color.Red else Color.Unspecified
            val backgroundColor = if (percentage > 80.0f) Color.Red.copy(alpha = 0.1f) else Color.Transparent

            Text(
                text = percentageRes.toString(),
                modifier = Modifier
                    .padding(15.dp)
                    .background(color = backgroundColor)
                    .padding(8.dp)
                    .background(color = textColor)
            )

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { viewModel.calculatePercentage(totalProdRes, actualProdRes) }) {
                    Text(text = "Calcular")
                }
            }
        }
    }
}



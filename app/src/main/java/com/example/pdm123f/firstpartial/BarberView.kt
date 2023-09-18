package com.example.pdm123f.firstpartial

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pdm123f.R

@Composable
fun BarberView(navController: NavController, viewModel: BarberViewModel) {

    val hairCountResult by viewModel.getHairCount().observeAsState(0)
    val beardCountResult by viewModel.getBeardCount().observeAsState(0)
    val hairBeardCountResult by viewModel.getHairAndBeardCount().observeAsState(0)
    val totalCostResult by viewModel.getTotalCost().observeAsState(0)


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hair),
                    contentDescription = "",
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                        .clickable { viewModel.incrementHair() }
                )
                Text(text = "${hairCountResult}")
            }

            Spacer(modifier = Modifier.width(30.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.beard),
                    contentDescription = "",
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                        .clickable { viewModel.incrementBeard() }
                )
                Text(text = "${beardCountResult}")
            }

            Spacer(modifier = Modifier.width(30.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hab),
                    contentDescription = "",
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp)
                        .clickable { viewModel.incrementHairBeard() }
                )
                Text(text = "${hairBeardCountResult}")
            }
        }
        Text(text = "Total: $totalCostResult",
            modifier = Modifier.padding(top = 16.dp),
            style = TextStyle(fontWeight = FontWeight.Bold,
                fontSize = 30.sp)
        )
    }
}
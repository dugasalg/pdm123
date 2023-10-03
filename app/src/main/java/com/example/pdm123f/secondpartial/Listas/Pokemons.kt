package com.example.pdm123f.secondpartial.Listas

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text
import com.example.pdm123f.R

data class Pokemons(val nombre: String, val altura: String, val tipo: String, val imagen: Int) {
    companion object {
        fun getPokemons(): List<Pokemons> {
            return listOf(
                Pokemons("Bulbasaur", "0.7 m", "Planta", R.drawable.apples),
                Pokemons("Ivysaur", "1.0 m", "Planta", R.drawable.apples),
                Pokemons("Venusaur", "2.0 m", "Planta", R.drawable.apples),
                Pokemons("Charmander", "0.6 m", "Fuego", R.drawable.apples),
                Pokemons("Charmeleon", "1.1 m", "Fuego", R.drawable.apples))
        }
    }
}

@Composable
fun DesignPoke(pokemons: Pokemons) {
    Row (modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = pokemons.nombre,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        )
        Text(
            text = pokemons.altura,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        )
        Text(
            text = pokemons.tipo,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        )
        Image(
            painter = painterResource(id = pokemons.imagen),
            contentDescription = "pokemon",
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        )
    }
}

@Composable
fun ListView(){
    LazyColumn(contentPadding = PaddingValues(20.dp),
    verticalArrangement = Arrangement.spacedBy(40.dp)
    ){
     item {
         Text(
             text = "Pokemons",
             style = TextStyle(
                 fontSize = 28.sp,
                 fontWeight = FontWeight.Black,
                 color = androidx.compose.ui.graphics.Color.Black
             )
         )
     }
        items(Pokemons.getPokemons().size) { index ->
            DesignPoke(pokemons = Pokemons.getPokemons()[index])
        }
    }
}

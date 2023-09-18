package com.example.pdm123f.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123f.R

class CardsViewModel : ViewModel() {
    // LiveData que contiene el ID de la imagen de la tarjeta actual
    val cardImageResId = MutableLiveData(R.drawable.back)

    // Método para obtener el LiveData del ID de la imagen actual
    fun getRandomImage(): MutableLiveData<Int> = cardImageResId

    // Método para obtener una tarjeta aleatoria
    fun getRandomCard(){
        val randomNumber = (1..13).random()
        // Asigna una imagen de tarjeta según el número aleatorio generado
        when (randomNumber){
            1 -> cardImageResId.postValue(R.drawable.h01)
            2 -> cardImageResId.postValue(R.drawable.h02)
            3 -> cardImageResId.postValue(R.drawable.h03)
            4 -> cardImageResId.postValue(R.drawable.h04)
            5 -> cardImageResId.postValue(R.drawable.h05)
            6 -> cardImageResId.postValue(R.drawable.h06)
            7 -> cardImageResId.postValue(R.drawable.h07)
            8 -> cardImageResId.postValue(R.drawable.h08)
            9 -> cardImageResId.postValue(R.drawable.h09)
            10 -> cardImageResId.postValue(R.drawable.h10)
            11 -> cardImageResId.postValue(R.drawable.hc1j)
            12 -> cardImageResId.postValue(R.drawable.hc2q)
            13 -> cardImageResId.postValue(R.drawable.hc3k)
        }
    }
    // Método para mostrar la parte posterior de la tarjeta
    fun showBackCard(){
        cardImageResId.postValue(R.drawable.back)
    }
}
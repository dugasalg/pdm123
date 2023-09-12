package com.example.pdm123f.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//El viewmodel siempre debe de heredar de la clase de viewmodel
class EvenOrOddViewModel: ViewModel() {
    var evenOrOddStatus = MutableLiveData<String>()
    var showFirstImage = MutableLiveData<Boolean>(false)
    fun getResultStatus(): MutableLiveData<String> = evenOrOddStatus
    fun getBooleanState(): MutableLiveData<Boolean> = showFirstImage
    fun calculateEvenOrOdd(number: Int) {
        if  (number != 0) {
            if (number % 2 == 0) {
            evenOrOddStatus.postValue( "El numero es par")
                showFirstImage.postValue(true)
        } else if (number % 2 == 1) {
                evenOrOddStatus.postValue("El numero es non")
                showFirstImage.postValue(false)
            }
        } else {
            evenOrOddStatus.postValue("El numero es 0")
        }
    }
}

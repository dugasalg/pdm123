package com.example.pdm123f.firstpartial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//El viewmodel siempre debe de heredar de la clase de viewmodel
class EvenOrOddViewModel: ViewModel() {
    // LiveData que almacena el estado de par o impar
    var evenOrOddStatus = MutableLiveData<String>()
    // LiveData que almacena si se debe mostrar la primera imagen
    var showFirstImage = MutableLiveData<Boolean>(false)
    // Método para obtener el estado de par o impar
    fun getResultStatus(): MutableLiveData<String> = evenOrOddStatus
    fun getBooleanState(): MutableLiveData<Boolean> = showFirstImage
    // Método para calcular si un número es par o impar

    fun calculateEvenOrOdd(number: Int) {
        if  (number != 0) {
            // Comprueba si el número es par o impar
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

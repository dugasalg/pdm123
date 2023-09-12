package com.example.pdm123f.firstpartial

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdm123f.R

data class NumberComparator(val number1: Int, val number2: Int, val number3: Int)

class NumberComparatorViewModel : ViewModel() {
    private val resultMessage = MutableLiveData<String>()

    fun getResult():LiveData<String> = resultMessage
    fun compareNumbers(numberComparator: NumberComparator) {
        val number1 = numberComparator.number1
        val number2 = numberComparator.number2
        val number3 = numberComparator.number3
        if (number1 != number2 && number2 != number3 && number1 != number3) {
            val numbers = listOf(number1, number2, number3)
            val sortedNumbers = numbers.sorted()
            resultMessage.postValue("MAX: ${sortedNumbers[2]}, MID: ${sortedNumbers[1]}, MIN: ${sortedNumbers[0]}")
        } else {
            resultMessage.postValue("Please type three different numbers")
        }
    }
}
package com.example.pdm123f.firstpartial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BarberViewModel : ViewModel() {
    private val hairCount = MutableLiveData(0)
    private val beardCount = MutableLiveData(0)
    private val hairBeardCount = MutableLiveData(0)

    // LiveData para el resultado final
    private val totalCost = MutableLiveData(0)

    fun getHairCount(): LiveData<Int> = hairCount
    fun getBeardCount(): LiveData<Int> = beardCount
    fun getHairAndBeardCount(): LiveData<Int> = hairBeardCount
    fun getTotalCost(): LiveData<Int> = totalCost

    fun incrementHair() {
        val currentCount = hairCount.value ?: 0
        hairCount.value = currentCount + 1
        calculateTotalCost()
    }

    fun incrementBeard() {
        val currentCount = beardCount.value ?: 0
        beardCount.value = currentCount + 1
        calculateTotalCost()
    }

    fun incrementHairBeard() {
        val currentCount = hairBeardCount.value ?: 0
        hairBeardCount.value = currentCount + 1
        calculateTotalCost()
    }

    private fun calculateTotalCost() {
        val hairCost = (hairCount.value ?: 0) * 350
        val beardCost = (beardCount.value ?: 0) * 450
        val hairBeardCost = (hairBeardCount.value ?: 0) * 800

        // Sumar los costos individuales para obtener el total
        val total = hairCost + beardCost + hairBeardCost
        totalCost.value = total
    }
}
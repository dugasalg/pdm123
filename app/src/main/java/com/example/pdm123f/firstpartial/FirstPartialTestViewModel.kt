import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ApplesViewModel : ViewModel() {
    val currentTotalProduction = mutableStateOf(0)
    val currentActualProduction = mutableStateOf(0)
    val percentage = mutableStateOf(0f)


    val totalProduction: State<Int> = currentTotalProduction
    val actualProduction: State<Int> = currentActualProduction

    val uiState = mutableStateOf<UIState>(UIState.Idle)


    fun increment(valueToIncrement: Int){
        if (uiState.value == UIState.Idle) {
            uiState.value = UIState.Adding5
            currentActualProduction.value += valueToIncrement
            calculatePercentage(currentTotalProduction.value, currentActualProduction.value)
            uiState.value = UIState.Idle
        }
    }


    fun calculatePercentage(total: Int, actual: Int) {
        if (uiState.value == UIState.Idle) {
            uiState.value = UIState.CalculatingPercentage
            if (total != 0) {
                val calculatedPercentage = (actual.toFloat() / total.toFloat()) * 100
                percentage.value = calculatedPercentage
                println("Calculated Percentage: $calculatedPercentage")
            }

            if (percentage.value >= 70){

            }
            uiState.value = UIState.Idle
        }
    }

    fun calculateTotalProdToast(context: Context) {
        if (uiState.value == UIState.Idle) {
            uiState.value = UIState.CalculatingTotalProdToast
            val total = currentTotalProduction.value
            val result = total * 70
            val toastMessage = "$result manzanas"
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            uiState.value = UIState.Idle
        }
    }

    fun calculateActualProdToast(context: Context) {
        if (uiState.value == UIState.Idle) {
            uiState.value = UIState.CalculatingActualProdToast
            val actual = currentActualProduction.value
            val result = actual * 80
            val toastMessage = "$result manzanas"
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            uiState.value = UIState.Idle
        }
    }
}

sealed class UIState {
    object Idle : UIState()
    object Adding5 : UIState()
    object Adding15 : UIState()
    object Adding30 : UIState()
    object Adding50 : UIState()
    object CalculatingPercentage : UIState()
    object CalculatingTotalProdToast : UIState()
    object CalculatingActualProdToast : UIState()
}
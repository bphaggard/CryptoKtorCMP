package org.example.project.ktorapitestcmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.example.project.ktorapitestcmp.data.CryptoCurrency
import org.example.project.ktorapitestcmp.network.getCryptoCurrencyApi

class HomeViewModel: ViewModel() {

    private val _coins = MutableStateFlow<List<CryptoCurrency>>(emptyList())
    val coins: StateFlow<List<CryptoCurrency>> = _coins

    init {
        fetchCoins()
    }

    fun fetchCoins() {
        viewModelScope.launch {
            try {
                val fetchedCoins = getCryptoCurrencyApi() // Calls your API function
                _coins.value = fetchedCoins // Updates the StateFlow with new data
            } catch (e: Exception) {
                println("HomeViewModel\", \"Error fetching coins: ${e.message}")
            }
        }
    }

    fun getCoinById(coinId: String): CryptoCurrency? {
        return coins.value.find { it.id == coinId }
    }
}
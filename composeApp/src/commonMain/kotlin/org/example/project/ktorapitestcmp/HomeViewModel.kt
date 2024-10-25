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

    private fun fetchCoins() {
        viewModelScope.launch {
            _coins.value = getCryptoCurrencyApi()
        }
    }
}
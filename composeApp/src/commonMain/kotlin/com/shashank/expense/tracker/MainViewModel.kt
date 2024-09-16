package com.shashank.expense.tracker

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shashank.expense.tracker.cache.Transactions
import kotlinx.coroutines.launch

class MainViewModel(private val sdk: TrackerSDK): ViewModel() {
    private val _state = mutableStateOf(TransactionsScreenState())
    val state: State<TransactionsScreenState> = _state

    init {
        loadTransactions()
    }

    fun loadTransactions() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, transactions = emptyList())
            try {
                val transactions = sdk.getTransactions()
                _state.value = _state.value.copy(isLoading = false,transactions = transactions)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false,transactions = emptyList())
            }

        }
    }
}

data class TransactionsScreenState(
    val isLoading: Boolean = false,
    val transactions: List<Transactions> = emptyList()
)
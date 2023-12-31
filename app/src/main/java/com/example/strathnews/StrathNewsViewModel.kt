package com.example.strathnewshub

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StrathNewsViewModel: ViewModel() {

    private val _isloading = MutableStateFlow(true)
    val isLoading = _isloading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _isloading.value = false
        }
    }
}
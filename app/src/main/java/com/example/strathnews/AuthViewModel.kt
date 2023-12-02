package com.example.strathnews

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.composable
import com.example.strathnews.ui.Home.HomeScreen
import com.example.strathnews.ui.Search.SearchScreen
import com.example.strathnews.ui.Settings.SettingScreen
import com.example.strathnews.ui.SingleNewsScreen

class AuthViewModel: ViewModel() {
    private var _isLoggedIn = false

    val isLoggedIn: Boolean
        get() = _isLoggedIn

    fun setLoggedIn(isLoggedIn: Boolean) {
        _isLoggedIn = isLoggedIn
    }

}


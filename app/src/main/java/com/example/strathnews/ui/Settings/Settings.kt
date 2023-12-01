package com.example.strathnews.ui.Settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.strathnews.ui.theme.StrathNewsTheme

@Composable
fun SettingScreen(){
    Text(text = "This is the Settings Screen")
}

@Preview
@Composable
fun SettingScreenPreview(){
    StrathNewsTheme {
        SettingScreen()
    }
}
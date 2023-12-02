package com.example.strathnews.ui.Settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.strathnews.ui.Search.SearchBar
import com.example.strathnews.ui.theme.StrathNewsTheme

@Composable
fun SettingScreen(){
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(text = "Settings", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        }
        Spacer(modifier = Modifier.padding(10.dp))
//        SearchBar(navController = mainNavController)
    }
}

@Preview
@Composable
fun SettingScreenPreview(){
    StrathNewsTheme {
        SettingScreen()
    }
}

package com.example.strathnews.ui.Settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
        LazyColumn(){
            items(settingItems){
                TabItems(name = it)
            }
        }

    }
}

//@Preview
//@Composable
//fun SettingScreenPreview(){
//    StrathNewsTheme {
//        SettingScreen()
//    }
//}


@Composable
fun TabItems(name: String){
    val color = if(name == "General") MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.background
    val textcolor = if(name == "Sign Out") MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onBackground
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .clickable {  }
            .background(color),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = name, color = textcolor)
    }
}

val settingItems: List<String> = listOf(
    "General",
    "Manage Account",
    "Activity",
    "Theme",
    "Send FeedBack",
    "Privacy Policy",
    "Terms of Use",
    "Sign Out"

)

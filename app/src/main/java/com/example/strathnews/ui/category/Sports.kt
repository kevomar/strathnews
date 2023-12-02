package com.example.strathnews.ui.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.strathnews.TopNews
import com.example.strathnews.data.NewsObject.newsList
import com.example.strathnews.ui.components.NewsView
import com.example.strathnews.ui.components.OtherNewsView

@Composable
fun Sports(navController: NavController){
    Column(
        modifier = Modifier.padding(top = 17.dp)
    ) {
        NewsView(news = newsList, navController = navController)
    }
}

//@Preview
//@Composable
//fun SportsPreview(){
//    Sports()
//}
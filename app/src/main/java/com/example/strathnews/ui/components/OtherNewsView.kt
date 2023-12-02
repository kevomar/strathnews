package com.example.strathnews.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.strathnews.data.News
import com.example.strathnews.data.NewsObject.newsList
import com.example.strathnews.ui.theme.StrathNewsTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherNewsView(
    news: List<News>,
    navController: NavController
){
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(){
            items(news){
                NewsCard(news = it, navController = navController)
            }
        }


    }
}


//@Preview
//@Composable
//fun OtherNewsViewPreview(){
//    StrathNewsTheme {
//        OtherNewsView(newsList)
//    }
//}
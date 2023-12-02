package com.example.strathnews.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.strathnews.data.News
import com.example.strathnews.data.NewsObject.newsObj1
import com.example.strathnews.ui.theme.StrathNewsTheme

@Composable
fun NewsView(
    news: List<News>,
    navController: NavController
){
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 10.dp)
        ){
            items(news){
                ListNewsCard(news = it, navController = navController)
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun NewsViewPreview(){
//    StrathNewsTheme {
//        NewsView()
//    }
//}
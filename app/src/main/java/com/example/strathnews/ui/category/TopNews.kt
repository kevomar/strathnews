package com.example.strathnews.ui.category

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.strathnews.data.NewsObject.newsList
import com.example.strathnews.ui.components.OtherNewsView

@Composable
fun TopNews(navController: NavController, onSingleNewsClick: (String) -> Unit = {}) {
    OtherNewsView(newsList, navController = navController)
}


//@Preview
//@Composable
//fun TopNewsPreview(){
//    TopNews { news ->
//        val navController = null
//        navController.navigateToSingleNews(news)
//    }
//}

/**
 * Top News -> OtherNewsView() -> NewsCard(news)
 * */
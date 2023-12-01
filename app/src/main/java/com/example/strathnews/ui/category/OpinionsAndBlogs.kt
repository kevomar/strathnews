package com.example.strathnews.ui.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.strathnews.data.NewsObject.newsList
import com.example.strathnews.ui.components.NewsView
import com.example.strathnews.ui.components.OtherNewsView

@Composable
fun OpinionsAndBlogs(){
    Column(
        modifier = Modifier.padding(top = 17.dp)
    ) {
        NewsView(news = newsList)
    }
}
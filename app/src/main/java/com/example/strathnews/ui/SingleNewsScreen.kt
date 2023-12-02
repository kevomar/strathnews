package com.example.strathnews.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.strathnews.data.News
import com.example.strathnews.data.NewsObject
import com.example.strathnews.data.NewsObject.newsObj1
import com.example.strathnews.ui.theme.StrathNewsTheme
import java.util.Date

@Composable
fun SingleNewsScreen(
    newsTitle: String? = NewsObject.newsList.first().title
){
    Log.d("Single news screen", "entered")
    val newsItem = NewsObject.getNews(newsTitle)
    Log.d("Single news screen", newsItem.toString())
   Column(
       modifier = Modifier.padding(top = 40.dp)
   ) {
        NewsPage(news = newsItem)
   }
}

@Composable
fun NewsPage(
    news: News
){
    IconsRow()
    TitleRow(news.title)
    Info_Image(news.image, news.author, news.date)
    Details(news.content)
}

@Composable
fun TitleRow(title: String) {
    Row (
        modifier = Modifier.padding(vertical = 8.dp)
    ){
        Text(text = title, fontSize = 32.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp, lineHeight = 30.sp, color = MaterialTheme.colorScheme.primary, modifier=Modifier.fillMaxWidth())
    }
}

@Composable
fun Info_Image(image: Int, author: String, date: Date) {
    Column {
        Row {
            Spacer(modifier = Modifier.padding(5.dp))
            Box(
                modifier = Modifier.padding(4.dp)
            ){
                IconItem(
                    icon = Icons.Filled.AccountCircle,
                    modifier = Modifier
                        .graphicsLayer(3f, 3f)
                        .padding(10.dp),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Column {
                Text(text = author)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = date.toString())
            }
        }
        Box(
            modifier = Modifier.padding(8.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                horizontalArrangement = Arrangement.Center
            ){
                Image(painter = painterResource(id = image), contentDescription = null)
            }

        }
    }
}

@Composable
fun Details(content: String) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
    ){
        Text(text = content, modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun IconsRow() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, modifier = Modifier.clickable {  })
        Row (
            modifier = Modifier.padding(horizontal = 4.dp)
        ){
            IconItem(icon = Icons.Filled.Share)
            IconItem(icon = Icons.Outlined.FavoriteBorder)
            IconItem(icon = Icons.Outlined.ThumbUp)
        }
    }
}

@Preview(showBackground = true,)
@Composable
fun SingleScreenPreview(){
    StrathNewsTheme{
        SingleNewsScreen(newsTitle = newsObj1.title)
    }
}

@Composable
fun IconItem(icon: ImageVector, modifier: Modifier = Modifier, color: Color = Color.Black){
    Box(
        modifier = Modifier.padding(horizontal = 6.dp)
    ){
        Icon(imageVector = icon, contentDescription = null, modifier = modifier, tint = color)
    }
}

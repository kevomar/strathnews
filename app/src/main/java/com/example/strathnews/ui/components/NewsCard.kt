package com.example.strathnews.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.strathnews.SingleNews
import com.example.strathnews.data.News
import com.example.strathnews.data.NewsObject.newsObj1
import com.example.strathnews.ui.Home.navigateToSingleNews
import com.example.strathnews.ui.theme.StrathNewsTheme
import com.example.strathnews.ui.theme.gold
import com.example.strathnews.ui.theme.lightGray


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsCard(news: News, navController: NavController )  {
    val navController = navController

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(lightGray)
            .clickable {
                Log.d("message", "arrived")
                navController.navigate("${SingleNews.route}/{${news.title}}")
            }
    ) {
        Card(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .background(lightGray),
        ) {
            NewsImageCard(painterResource(id = news.image),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .background(lightGray))
            Spacer(modifier = Modifier.padding(13.dp).background(lightGray))
            NewsDetails(
                title = news.title,
                description = news.description,
                author = news.author
            )

            
        }
    }
}



@Composable
fun NewsImageCard(image: Painter, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Image(painter = image, contentDescription = "image", modifier = modifier)
    }
}

@Composable
fun NewsDetails(title: String, description: String, author: String) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = description, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(2.dp))
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = author, modifier = Modifier.padding(5.dp))
        }
    }
}


//@Preview
//@Composable
//fun NewsCardPreview(){
//    StrathNewsTheme {
//        NewsCard(news = newsObj1)
//    }
//}

private val cardHeight = 80.dp
private val cardWidth = 100.dp
@Composable
fun ListNewsCard(news: News, navController: NavController){
    val navController = navController
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .drawBehind {
                val width = size.width
                val height = size.height - width / 2
                drawLine(
                    color = gold,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 6f
                )
            }
            .clickable { navController.navigate("${SingleNews.route}/{${news.title}}") }
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            NewsImageCard(image = painterResource(id = news.image),
                modifier = Modifier
                    .height(cardHeight)
                    .width(cardWidth)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                NewsDetails(
                    title = news.title,
                    description = news.description,
                    author = news.author
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun ListNewsCardPreview(){
//   StrathNewsTheme {
//       ListNewsCard(news = newsObj1)
//   }
//}
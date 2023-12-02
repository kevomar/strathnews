package com.example.strathnews.ui.Search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.strathnews.data.NewsObject
import com.example.strathnews.ui.components.NewsView
import com.example.strathnews.ui.theme.StrathNewsTheme

@Composable
fun SearchScreen(
    mainNavController: NavController
){
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(text = "Search", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        SearchBar(navController = mainNavController)
    }

}

//@Preview(
//    showBackground = true
//)
//@Composable
//fun SearchScreenPreview(){
//    StrathNewsTheme {
//        SearchScreen()
//    }
//}

//@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(navController: NavController){
    var text by remember { mutableStateOf("") }

    Column {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Search") },
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                trailingIcon = { Icon(Icons.Outlined.Clear, contentDescription = null) },
                shape = RoundedCornerShape(25.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        val filteredNewsList = remember {
            derivedStateOf {
                NewsObject.newsList.filter { news ->
                    news.title.contains(text, ignoreCase = true)
                }
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        if(text != "") {
            NewsView(news = filteredNewsList.value, navController = navController)
        }


    }

}
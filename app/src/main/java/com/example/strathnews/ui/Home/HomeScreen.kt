package com.example.strathnews.ui.Home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.strathnews.Clubs
import com.example.strathnews.Entertainment
import com.example.strathnews.OpinionsAndBlogs
import com.example.strathnews.SingleNews
import com.example.strathnews.Sports
import com.example.strathnews.TopNews
import com.example.strathnews.sections
import com.example.strathnews.ui.category.Clubs
import com.example.strathnews.ui.category.Entertainment
import com.example.strathnews.ui.category.OpinionsAndBlogs
import com.example.strathnews.ui.category.Sports
import com.example.strathnews.ui.category.TopNews
import com.example.strathnews.ui.components.TopNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(mainNavController: NavController){
//    Text("This is the Home Screen from the Home package")
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = sections.find {it.route == currentDestination?.route } ?: TopNews
    Scaffold(
        topBar = {
            TopNavBar(
                allScreens = sections,
                onTabSelected = {newscreen->
                    navController.navigateSingleTopTo(newscreen.route)
                },
                currentScreen = currentScreen
            )
        }
    ) {_ ->
        NavHost(navController = navController, startDestination = TopNews.route){
            composable(route = TopNews.route){
                TopNews(navController = mainNavController)
            }
            composable(route = Sports.route){
                Sports()
            }
            composable(route = Entertainment.route){
                Entertainment()
            }
            composable(route = Clubs.route){
                Clubs()
            }
            composable(route = OpinionsAndBlogs.route){
                OpinionsAndBlogs()
            }
        }

    }
}

//@Preview
//@Composable
//fun HomeScreenPreview(){
//    HomeScreen()
//}

fun NavHostController.navigateSingleTopTo(route: String){
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ){
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavHostController.navigateToSingleNews(news: String){
    this.navigateSingleTopTo("${SingleNews.route}/$news")
}
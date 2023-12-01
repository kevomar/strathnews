package com.example.strathnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.strathnews.ui.Home.HomeScreen
import com.example.strathnews.ui.Search.SearchScreen
import com.example.strathnews.ui.Settings.SettingScreen
import com.example.strathnews.ui.components.BottomNav
import com.example.strathnews.ui.theme.StrathNewsTheme

class StrathNewsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StrathNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary

                ) {
                    StrathNews()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun StrathNews(){
    StrathNewsTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = bottomNavItems.find {it.route == currentDestination?.route } ?: Home

        Scaffold(
            bottomBar = {
                BottomNav(
                    allScreens = bottomNavItems,
                    onTabSelected = {
                            newscreen ->
                        navController.navigateSingleTopTo(newscreen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ){_ ->
            NavHost(navController = navController, startDestination = Home.route ){
                composable(route = Home.route){
                    HomeScreen()
                }
                composable(route = Search.route) {
                    SearchScreen()
                }
                composable(route = Settings.route){
                    SettingScreen()
                }
            }

        }
    }
}


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

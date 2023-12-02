package com.example.strathnews

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.navigation.NavType
import androidx.navigation.navArgument


interface Destination{
    val icon: ImageVector
    val route: String
}

object Home: Destination {
    override val icon = Icons.Filled.Home
    override val route = "home"
}

object Search: Destination {
    override val icon = Icons.Filled.Search
    override val route = "search"
}

object Settings: Destination {
    override val icon = Icons.Filled.Settings
    override val route = "settings"
}

object SingleNews: Destination{
    override val icon = Icons.Filled.DateRange
    override val route = "single_news"
    const val title = "news title"
    val routeWithArgs = "${SingleNews.route}/{${SingleNews.title}}"
    val arguments =  listOf(
        navArgument(title) {type = NavType.StringType}
    )

}

val bottomNavItems = listOf(Home, Search, Settings)
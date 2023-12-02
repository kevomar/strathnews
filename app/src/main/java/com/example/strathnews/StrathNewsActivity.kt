package com.example.strathnews

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.strathnews.ui.Home.HomeScreen
import com.example.strathnews.ui.Search.SearchScreen
import com.example.strathnews.ui.Settings.SettingScreen
import com.example.strathnews.ui.SingleNewsScreen
import com.example.strathnews.ui.components.BottomNav
//import com.example.strathnews.ui.login.LoginScreen
import com.example.strathnews.ui.theme.StrathNewsTheme
import com.example.strathnews.ui.theme.lightGray
import com.example.strathnewshub.StrathNewsViewModel

class StrathNewsActivity : ComponentActivity() {
    private val viewModel: StrathNewsViewModel by viewModels()
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{

                viewModel.isLoading.value
            }
        }
        setContent {
            StrathNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    StrathNews(authViewModel)
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview
fun StrathNews(
    authViewModel: AuthViewModel
){
    var isLoggedin by remember {
        mutableStateOf(false)
    }
    @Composable
    fun LoginScreen(
        authViewModel: AuthViewModel
    ){
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
//            .padding(20.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.padding(top  = 30.dp))
            Text(text = "Login",
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(16.dp))
            TextField(
                value = username,
                onValueChange ={ username = it},
                label = { Text(text = "Admission No") },
                shape = RoundedCornerShape(4.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    containerColor = lightGray
                ),
            )
            Spacer(modifier = Modifier.padding(16.dp))
            TextField(
                value = password,
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                onValueChange ={ password = it},
                label = { Text(text = "Password") },
                shape = RoundedCornerShape(4.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    containerColor = lightGray
                ),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        if(passwordVisibility){
                            Icon(painter = painterResource(id = R.drawable.closed_eye), contentDescription = null)
                        }else{
                            Icon(painter = painterResource(id = R.drawable.open_eye), contentDescription = null)
                        }
                    }
                },
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                Text(
                    text = "Forgot Password ?",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Spacer(modifier = Modifier.padding(horizontal = 32.dp))
            }
            Spacer(modifier = Modifier.padding(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 52.dp)
            ) {
                Button(
                    onClick = { isLoggedin = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(
                        text = "LOGIN",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
    StrathNewsTheme {
//        var isLoggedIn by remember { mutableStateOf(false) }
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = bottomNavItems.find {it.route == currentDestination?.route } ?: Home

        if(isLoggedin){
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
                        HomeScreen(mainNavController = navController)
                    }
                    composable(route = Search.route) {
                        SearchScreen(mainNavController = navController)
                    }
                    composable(route = Settings.route){
                        SettingScreen()
                    }
                    composable(route = SingleNews.routeWithArgs, arguments = SingleNews.arguments){
                            navBackStackEntry ->
                        //retrieve the passed argument
                        val newsTitle =
                            navBackStackEntry.arguments?.getString(SingleNews.title)
                        //pass the argument to the screen
                        Log.d("navEntry", newsTitle.toString())
                        SingleNewsScreen(newsTitle, navController)
                    }
                }

            }
        } else {
            LoginScreen(authViewModel)
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




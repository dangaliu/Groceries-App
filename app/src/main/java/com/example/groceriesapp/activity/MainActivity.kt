package com.example.groceriesapp.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.groceriesapp.composable.component.bottombar.GroceryBottomBar
import com.example.groceriesapp.navigation.GroceryNavigation
import com.example.groceriesapp.navigation.NavConstants
import com.example.groceriesapp.ui.theme.GroceriesAppTheme
import com.example.groceriesapp.ui.theme.Primary
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroceriesAppTheme {
                App()
            }
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        val context = LocalContext.current
        val scaffoldState = rememberScaffoldState()
        val systemUiController = rememberSystemUiController()

        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        val bottomScreens = listOf(
            NavConstants.shop,
            NavConstants.explore,
            NavConstants.cart,
            NavConstants.favourite,
            NavConstants.account
        )

        LaunchedEffect(Unit) {
            systemUiController.setSystemBarsColor(Primary)
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Color.White,
            bottomBar = {
                if (currentRoute in bottomScreens) {
                    Surface(
                        shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(92.dp),
                        elevation = 10.dp,
                        color = Color.White
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            GroceryBottomBar(
                                navController = navController
                            )
                        }

                    }
                }
            },
            scaffoldState = scaffoldState
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                GroceryNavigation(navController = navController)
            }
        }

    }
}

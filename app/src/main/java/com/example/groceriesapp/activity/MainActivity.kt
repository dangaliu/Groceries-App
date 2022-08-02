package com.example.groceriesapp.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.groceriesapp.navigation.GroceryNavigation
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

        LaunchedEffect(Unit) {
            systemUiController.setSystemBarsColor(Primary)
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Color.White
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

package com.example.groceriesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.groceriesapp.composable.screen.onBoarding.view.OnBoardingScreen
import com.example.groceriesapp.composable.screen.splash.view.SplashScreen

@Composable
fun GroceryNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavConstants.splash
    ) {
        
        composable(route = NavConstants.splash) {
            SplashScreen(navController = navController)
        }
        
        composable(route = NavConstants.onBoarding) {
            OnBoardingScreen(navController = navController)
        }
    }
}
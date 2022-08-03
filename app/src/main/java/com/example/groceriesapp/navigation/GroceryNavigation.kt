package com.example.groceriesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.groceriesapp.composable.screen.onBoarding.view.OnBoardingScreen
import com.example.groceriesapp.composable.screen.auth.view.AuthScreen
import com.example.groceriesapp.composable.screen.bottombar.account.view.AccountScreen
import com.example.groceriesapp.composable.screen.bottombar.cart.view.CartScreen
import com.example.groceriesapp.composable.screen.bottombar.explore.view.ExploreScreen
import com.example.groceriesapp.composable.screen.bottombar.favourite.view.FavoriteScreen
import com.example.groceriesapp.composable.screen.bottombar.shop.view.ShopScreen
import com.example.groceriesapp.composable.screen.login_signup.view.LoginSignupScreen
import com.example.groceriesapp.composable.screen.phone.view.PhoneAuthScreen
import com.example.groceriesapp.composable.screen.select_location.view.SelectLocationScreen
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

        composable(route = NavConstants.auth) {
            AuthScreen(navController = navController)
        }

        composable(route = NavConstants.phoneAuth) {
            PhoneAuthScreen(navController = navController)
        }

        composable(route = NavConstants.selectLocation) {
            SelectLocationScreen(navController = navController)
        }

        composable(route = NavConstants.loginSignup) {
            LoginSignupScreen(navController = navController)
        }

        // Bottom Bar Screens

        composable(route = NavConstants.shop) {
            ShopScreen(navController = navController)
        }

        composable(route = NavConstants.explore) {
            ExploreScreen(navController = navController)
        }

        composable(route = NavConstants.cart) {
            CartScreen(navController = navController)
        }

        composable(route = NavConstants.favourite) {
            FavoriteScreen(navController = navController)
        }

        composable(route = NavConstants.account) {
            AccountScreen(navController = navController)
        }
    }
}
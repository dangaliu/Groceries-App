package com.example.groceriesapp.composable.screen.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.groceriesapp.R
import com.example.groceriesapp.navigation.NavConstants
import com.example.groceriesapp.ui.theme.Primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize().background(color = Primary),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(horizontal = 73.dp)
                .fillMaxWidth(),
            tint = Color.White
        )
    }

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(NavConstants.onBoarding) {
            popUpTo(NavConstants.splash) {
                inclusive = true
            }
        }
    }
}
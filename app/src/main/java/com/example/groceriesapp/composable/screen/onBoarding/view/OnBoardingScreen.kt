package com.example.groceriesapp.composable.screen.onBoarding.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.groceriesapp.R

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_background),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(bottom = 90.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}
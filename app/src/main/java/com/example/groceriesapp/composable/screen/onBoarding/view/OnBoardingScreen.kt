package com.example.groceriesapp.composable.screen.onBoarding.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.groceriesapp.R
import com.example.groceriesapp.composable.component.GroceryButton
import com.example.groceriesapp.navigation.NavConstants
import com.example.groceriesapp.ui.theme.GroceryLight
import com.example.groceriesapp.ui.theme.GroceryLightGray
import com.example.groceriesapp.ui.theme.gilroy

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_background),
            contentDescription = "background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(bottom = 90.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_logo_without_text),
                contentDescription = "logo"
            )
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Welcome \n" +
                        "to our store",
                fontFamily = gilroy,
                fontSize = 48.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(19.dp))
            Text(
                text = "Ger your groceries in as fast as one hour",
                fontFamily = gilroy,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = GroceryLightGray
            )
            Spacer(modifier = Modifier.height(40.dp))
            GroceryButton(
                text = "Get started",
                onClick = {
                    navController.navigate(NavConstants.phoneAuth)
                }
            )
        }
    }
}
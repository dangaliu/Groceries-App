package com.example.groceriesapp.composable.screen.login_signup.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.groceriesapp.R
import com.example.groceriesapp.composable.screen.phone.view.ActivationCodeInput
import com.example.groceriesapp.composable.screen.phone.view.PhoneInput
import com.example.groceriesapp.composable.screen.phone.viewmodel.PhoneAuthState
import com.example.groceriesapp.ui.theme.GroceryIconButtonText

@Composable
fun LoginSignupScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GroceryIconButtonText)
    ) {
        Image(
            painter = painterResource(R.drawable.phone_auth_background),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxWidth()
                .height(222.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_color_logo_without_text),
                contentDescription = "logo",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun Login(
    navController: NavHostController
) {

}

@Composable
fun Signup(
    navController: NavHostController
) {

}
package com.example.groceriesapp.composable.screen.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.groceriesapp.R
import com.example.groceriesapp.composable.component.GroceryIconButton
import com.example.groceriesapp.composable.component.GroceryTextField
import com.example.groceriesapp.navigation.NavConstants
import com.example.groceriesapp.ui.theme.GroceryScreenBackgroundLight
import com.example.groceriesapp.ui.theme.subTitleStyle
import com.example.groceriesapp.ui.theme.titleStyle

@Composable
fun AuthScreen(
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GroceryScreenBackgroundLight)
    ) {
        Image(
            painter = painterResource(id = R.drawable.phone_auth_image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(374.dp)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 24.dp)
                .padding(bottom = 90.dp)
                .fillMaxWidth()
        ) {
            var phone by remember { mutableStateOf("") }
            Text(
                text = "Get your groceries\n" +
                        "with nectar",
                style = titleStyle
            )
            Spacer(modifier = Modifier.height(30.dp))
            GroceryTextField(
                value = phone,
                onValueChange = {
                    phone = it
                },
                icon = R.drawable.phone_country_image,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                modifier = Modifier
                    .clickable { }
                    .fillMaxWidth(),
                text = "Or connect with social media",
                style = subTitleStyle.copy(
                    color = Color(0xFF828282),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(37.dp))
            GroceryIconButton(
                icon = R.drawable.ic_google,
                backgroundColor = Color(0xFF5383EC),
                text = "Continue with Google",
                onClick = {
                    navController.navigate(NavConstants.phoneAuth)
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            GroceryIconButton(
                icon = R.drawable.ic_facebook,
                backgroundColor = Color(0xFF4A66AC),
                text = "Continue with Facebook",
                onClick = {}
            )
        }
    }
}
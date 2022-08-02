package com.example.groceriesapp.composable.screen.select_location.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groceriesapp.R
import com.example.groceriesapp.composable.component.GroceryButton
import com.example.groceriesapp.composable.component.GrocerySpinner
import com.example.groceriesapp.composable.screen.phone.view.ActivationCodeInput
import com.example.groceriesapp.composable.screen.phone.view.PhoneInput
import com.example.groceriesapp.composable.screen.phone.viewmodel.PhoneAuthState
import com.example.groceriesapp.navigation.NavConstants
import com.example.groceriesapp.ui.theme.GroceryIconButtonText
import com.example.groceriesapp.ui.theme.subTitleStyle
import com.example.groceriesapp.ui.theme.titleStyle

@Composable
fun SelectLocationScreen(
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
        Icon(
            painter = painterResource(id = R.drawable.ic_navigation_arrow),
            contentDescription = "navigation arrow",
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(start = 25.dp, top = 24.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 25.dp)
                .padding(bottom = 80.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(45.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_location_image),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = "Select Your Location",
                style = titleStyle
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Swithch on your location to stay in tune with\n" +
                        "what’s happening in your area\n",
                style = subTitleStyle,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(89.dp))
            Text(
                text = "Your Zone",
                style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(10.dp))
            GrocerySpinner()
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Your Area",
                style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier.align(Alignment.Start)
            )
            GrocerySpinner()
            Spacer(modifier = Modifier.size(40.dp))
            GroceryButton(text = "Submit", onClick = {
                navController.navigate(NavConstants.loginSignup)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectLocationScreenPreview() {
    SelectLocationScreen(navController = rememberNavController())
}
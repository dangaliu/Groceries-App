package com.example.groceriesapp.composable.screen.phone.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.groceriesapp.R
import com.example.groceriesapp.composable.component.GroceryTextField
import com.example.groceriesapp.composable.screen.phone.viewmodel.PhoneAuthState
import com.example.groceriesapp.composable.screen.phone.viewmodel.PhoneAuthViewModel
import com.example.groceriesapp.navigation.NavConstants
import com.example.groceriesapp.ui.theme.*

@Composable
fun PhoneAuthScreen(
    navController: NavHostController,
    viewModel: PhoneAuthViewModel = hiltViewModel()
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
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_navigation_arrow),
                contentDescription = "navigation arrow",
                tint = Color.Unspecified,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Spacer(modifier = Modifier.height(65.dp))
            when(viewModel.phoneAuthState.value) {
                PhoneAuthState.PHONE -> PhoneInput()
                PhoneAuthState.CODE -> ActivationCodeInput(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PhoneInput(
    viewModel: PhoneAuthViewModel = hiltViewModel()
) {

    var phone by remember { mutableStateOf("") }
    val keyboard = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Enter your mobile number",
            style = titleStyle
        )
        Spacer(modifier = Modifier.height(27.dp))
        Text(
            text = "Mobile Number",
            style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(10.dp))
        GroceryTextField(
            value = phone,
            onValueChange = {
                phone = it
            },
            icon = R.drawable.phone_country_image,
            focusRequester = focusRequester,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(222.dp))
        FloatingActionButton(
            onClick = {
                      viewModel.changeState(PhoneAuthState.CODE)
            },
            backgroundColor = Primary,
            elevation = FloatingActionButtonDefaults.elevation(0.dp),
            modifier = Modifier
                .size(67.dp)
                .align(Alignment.End)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_navigation_arrow),
                contentDescription = "Floating action button",
                tint = Color.White,
                modifier = Modifier
                    .rotate(180f)
                    .size(10.dp, 18.dp)
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ActivationCodeInput(
    viewModel: PhoneAuthViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var code by remember { mutableStateOf("") }
    val keyboard = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Enter your 4-digit code",
            style = titleStyle
        )
        Spacer(modifier = Modifier.height(27.dp))
        Text(
            text = "Code",
            style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(10.dp))
        GroceryTextField(
            value = code,
            onValueChange = {
                code = it
                if (code == "4444") {
                    navController.navigate(NavConstants.selectLocation)
                }
            },
            icon = null,
            focusRequester = focusRequester,
            startValue = null,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(222.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Resend Code",
                fontFamily = gilroy,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Primary,
                modifier = Modifier.clickable {  }
            )
            FloatingActionButton(
                onClick = {
                          viewModel.changeState(PhoneAuthState.PHONE)
                },
                backgroundColor = Primary,
                elevation = FloatingActionButtonDefaults.elevation(0.dp),
                modifier = Modifier
                    .size(67.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_navigation_arrow),
                    contentDescription = "Floating action button",
                    tint = Color.White,
                    modifier = Modifier
                        .rotate(180f)
                        .size(10.dp, 18.dp)
                )
            }
        }

    }
}
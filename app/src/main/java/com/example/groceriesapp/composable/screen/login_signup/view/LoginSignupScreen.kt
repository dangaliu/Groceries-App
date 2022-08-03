package com.example.groceriesapp.composable.screen.login_signup.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.groceriesapp.R
import com.example.groceriesapp.composable.component.GroceryButton
import com.example.groceriesapp.composable.component.GroceryTextField
import com.example.groceriesapp.composable.screen.login_signup.viewmodel.LoginSignupState
import com.example.groceriesapp.composable.screen.login_signup.viewmodel.LoginSignupViewModel
import com.example.groceriesapp.ui.theme.*

@Composable
fun LoginSignupScreen(
    navController: NavHostController,
    viewModel: LoginSignupViewModel = hiltViewModel()
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
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(42.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_color_logo_without_text),
                contentDescription = "logo",
                tint = Color.Unspecified,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(100.dp))
            when(viewModel.state.value) {
                LoginSignupState.LOGIN -> Login(navController = navController)
                LoginSignupState.SIGNUP -> Signup(navController = navController)
            }
        }
    }
}

@Composable
fun Login(
    navController: NavHostController,
    viewModel: LoginSignupViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("imshuvo97@gmail.com") }
    var password by remember { mutableStateOf("kkkkkkkk") }
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = "Loging",
            style = titleStyle
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Enter your emails and password",
            style = subTitleStyle
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Email",
            style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(10.dp))
        GroceryTextField(
            value = email,
            onValueChange = {
                email = it
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Password",
            style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(10.dp))
        GroceryTextField(
            value = password,
            onValueChange = {
                password = it
            },
            isPassword = true
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Forgot Password?",
            fontFamily = gilroy,
            color = Color(0xFF181725),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { }
        )
        Spacer(modifier = Modifier.height(30.dp))
        GroceryButton(text = "Log In", onClick = {})
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = AnnotatedString(
                text = "Don’t have an account? ",
                spanStyle = SpanStyle(
                    fontFamily = gilroy,
                    color = Color(0xFF181725),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            ).plus(
                AnnotatedString(
                    text = "Sign Up",
                    spanStyle = SpanStyle(
                        fontFamily = gilroy,
                        color = Primary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    viewModel.changeState(LoginSignupState.SIGNUP)
                }
        )
    }

}

@Composable
fun Signup(
    navController: NavHostController,
    viewModel: LoginSignupViewModel = hiltViewModel()
) {
    var username by remember { mutableStateOf("Afsar Hossen Shuvo") }
    var email by remember { mutableStateOf("imshuvo97@gmail.com") }
    var password by remember { mutableStateOf("kkkkkkkk") }
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Sign Up",
            style = titleStyle
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Enter your credentials to continue",
            style = subTitleStyle
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Username",
            style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(15.dp))
        GroceryTextField(
            value = username,
            onValueChange = {
                username = it
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Email",
            style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(15.dp))
        GroceryTextField(
            value = email,
            onValueChange = {
                email = it
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Password",
            style = subTitleStyle.copy(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(15.dp))
        GroceryTextField(
            value = password,
            onValueChange = {
                password = it
            },
            isPassword = true
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = AnnotatedString(
                text = "By continuing you agree to our "
            ).plus(
                AnnotatedString(
                    text = "Terms of Service\n",
                    spanStyle = SpanStyle(color = Primary)
                )
            ).plus(
                AnnotatedString(
                    text = "and Privacy Policy."
                )
            ),
            style = TextStyle(
                fontFamily = gilroy,
                color = Color(0xFF7C7C7C),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        GroceryButton(text = "Sign Up")
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = AnnotatedString(
                text = "Already have an account?  ",
                spanStyle = SpanStyle(
                    fontFamily = gilroy,
                    color = Color(0xFF181725),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            ).plus(
                AnnotatedString(
                    text = "Log In",
                    spanStyle = SpanStyle(
                        fontFamily = gilroy,
                        color = Primary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {
                    viewModel.changeState(LoginSignupState.LOGIN)
                }
        )
    }
}
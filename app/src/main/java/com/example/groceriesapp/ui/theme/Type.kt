package com.example.groceriesapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val textFieldTextStyle = TextStyle(
    color = Color(0xff181725),
    fontFamily = gilroy,
    fontSize = 18.sp,
    fontWeight = FontWeight.Medium
)

val titleStyle = TextStyle(
    color = Color(0xFF030303),
    fontFamily = gilroy,
    fontSize = 26.sp,
    fontWeight = FontWeight.SemiBold
)

val subTitleStyle = TextStyle(
    color = Color(0xFF7C7C7C),
    fontFamily = gilroy,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium
)
package com.example.groceriesapp.composable.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceriesapp.R
import com.example.groceriesapp.ui.theme.gilroy

@Composable
fun GrocerySearchComponent(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(52.dp),
    value: String,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search_icon),
                contentDescription = "search icon",
                tint = Color.Unspecified
            )
        },
        placeholder = {
            Text(
                text = "Search Store",
                color = Color(0xFF7C7C7C),
                fontFamily = gilroy,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        },
        modifier = modifier,
        textStyle = TextStyle(
            color = Color(0xFF181B19),
            fontFamily = gilroy,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        ),
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(0xFFF2F3F2),
            focusedBorderColor = Color(0xFFF2F3F2),
            unfocusedBorderColor = Color(0xFFF2F3F2),
            cursorColor = Color.Gray
        ),
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun GrocerySearchComponentPreview() {
    var value by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        GrocerySearchComponent(
            value = value,
            onValueChange = {
                value = it
            }
        )
    }
}
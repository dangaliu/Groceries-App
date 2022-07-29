package com.example.groceriesapp.composable.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceriesapp.ui.theme.GroceryLight
import com.example.groceriesapp.ui.theme.Primary
import com.example.groceriesapp.ui.theme.gilroy

@Composable
fun GroceryButton(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(67.dp),
    radius: Dp = 19.dp,
    text: String,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = { onClick()},
        modifier = modifier,
        shape = RoundedCornerShape(radius),
        border = null,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Primary
        )
    ) {
        Text(
            text = text,
            fontFamily = gilroy,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = GroceryLight
        )
    }
}
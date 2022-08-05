package com.example.groceriesapp.composable.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceriesapp.ui.theme.GroceryIconButtonText
import com.example.groceriesapp.ui.theme.gilroy

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GroceryIconButton(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(67.dp),
    icon: Int,
    text: String,
    radius: Dp = 19.dp,
    onClick: () -> Unit = {},
    backgroundColor: Color
) {
    Surface(
        onClick = {onClick()},
        color = backgroundColor,
        shape = RoundedCornerShape(radius),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(35.dp))
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "logo",
                tint = Color.Unspecified
            )
            Text(
                text = text,
                fontFamily = gilroy,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = GroceryIconButtonText,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }
    }
}
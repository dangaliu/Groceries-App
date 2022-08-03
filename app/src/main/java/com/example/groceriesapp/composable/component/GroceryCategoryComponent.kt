package com.example.groceriesapp.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceriesapp.R
import com.example.groceriesapp.ui.theme.gilroy

@Composable
fun GroceryCategoryComponent(
    modifier: Modifier = Modifier.size(248.dp, 105.dp),
    image: Int = R.drawable.pulses,
    title: String = "Pulses",
    color: Color = Color(0xFFF8A44C)
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        color = color.copy(alpha = 0.15f)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.pulses),
                contentDescription = null,
                modifier = Modifier.size(72.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = title,
                fontFamily = gilroy,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF3E423F)
            )
        }
    }
}
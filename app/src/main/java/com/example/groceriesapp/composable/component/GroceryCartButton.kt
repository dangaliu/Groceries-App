package com.example.groceriesapp.composable.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceriesapp.R
import com.example.groceriesapp.ui.theme.Primary

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GroceryCartButton(
    modifier: Modifier = Modifier.size(45.dp),
    onClick: () -> Unit = {},
    backgroundColor: Color = Primary,
    contentColor: Color = Color.White,
    icon: Int = R.drawable.ic_add,
    isDisabled: Boolean = false,
    isOutlined: Boolean = false
) {
    Surface(
        modifier = modifier,
        onClick = { onClick() },
        color = backgroundColor,
        contentColor = if (isDisabled) Color(0xFFB3B3B3) else contentColor,
        shape = RoundedCornerShape(17.dp),
        border = if (isOutlined) BorderStroke(
            width = 1.dp,
            color = if (isDisabled) Color(0xFFF0F0F0) else Color(0xFFE2E2E2)
        ) else null
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "add",
            modifier = Modifier.padding(14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddToCartButtonPreview() {
    GroceryCartButton()
}
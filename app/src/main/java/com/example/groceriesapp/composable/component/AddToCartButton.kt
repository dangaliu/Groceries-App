package com.example.groceriesapp.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceriesapp.R
import com.example.groceriesapp.ui.theme.Primary

@Composable
fun AddToCartButton(
    modifier: Modifier = Modifier.size(45.dp),
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier,
        color = Primary,
        contentColor = Color.White,
        shape = RoundedCornerShape(17.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "add",
            modifier = Modifier.padding(14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddToCartButtonPreview() {
    AddToCartButton()
}
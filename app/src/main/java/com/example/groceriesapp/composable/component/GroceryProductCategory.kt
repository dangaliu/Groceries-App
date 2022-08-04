package com.example.groceriesapp.composable.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceriesapp.R
import com.example.groceriesapp.model.dto.GroceryProductCategoryItem
import com.example.groceriesapp.ui.theme.subTitleStyle

@Composable
fun GroceryProductCategory(
    modifier: Modifier = Modifier.height(190.dp).fillMaxSize(),
    item: GroceryProductCategoryItem = GroceryProductCategoryItem(
        image = R.drawable.fruits_vegetable,
        title = "Frash Fruits\n" +
                "& Vegetable",
        color = Color(0xFF53B175)
    ),
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(
            width = 1.dp,
            color = item.color.copy(alpha = 0.7f)
        ),
        color = item.color.copy(alpha = 0.1f)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .sizeIn(
                        minWidth = 95.dp,
                        minHeight = 70.dp,
                        maxWidth = 115.dp,
                        maxHeight = 75.dp
                    )
                    .weight(1f)
            )
            Text(
                text = item.title,
                style = subTitleStyle.copy(color = Color(0xFF181725), fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(26.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GroceryProductCategoryPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        GroceryProductCategory()
    }
}
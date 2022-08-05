package com.example.groceriesapp.composable.component

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceriesapp.R
import com.example.groceriesapp.model.dto.GroceryComponentItem
import com.example.groceriesapp.ui.theme.GroceryDark
import com.example.groceriesapp.ui.theme.subTitleStyle

@Composable
fun GroceryItemComponent(
    modifier: Modifier = Modifier.size(173.dp, 249.dp),
    item: GroceryComponentItem = GroceryComponentItem(
        image = R.drawable.banana,
        title = "Organic Bananas",
        description = "7pcs, Priceg",
        price = "\$4.99"
    )
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFFE2E2E2)
        ),
        modifier = modifier
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.padding(bottom = 15.dp, start = 15.dp, end = 15.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.CenterHorizontally).sizeIn(
                        minWidth = 40.dp,
                        minHeight = 85.dp,
                        maxWidth = 100.dp,
                        maxHeight = 100.dp
                    )
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = item.title,
                    style = subTitleStyle.copy(color = GroceryDark, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.Start),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = item.description,
                    style = subTitleStyle.copy(fontSize = 14.sp),
                    modifier = Modifier.weight(1f)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.price,
                        style = subTitleStyle.copy(
                            color = GroceryDark,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    GroceryCartButton(
                        onClick = {}
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GroceryComponentPreview() {
    GroceryItemComponent()
}
package com.example.groceriesapp.composable.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groceriesapp.R
import com.example.groceriesapp.model.dto.GroceryComponentItem
import com.example.groceriesapp.ui.theme.Primary
import com.example.groceriesapp.ui.theme.gilroy

@Composable
fun CartItemComponent(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(97.dp),
    item: GroceryComponentItem = GroceryComponentItem(
        image = R.drawable.banana,
        title = "Organic Bananas",
        description = "7pcs, Priceg",
        price = "\$4.99"
    ),
    count: Int,
    onMinusChange: () -> Unit,
    onPlusChange: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier.sizeIn(
                    minWidth = 60.dp,
                    minHeight = 50.dp,
                    maxWidth = 90.dp,
                    maxHeight = 90.dp
                )
            )
            Spacer(modifier = Modifier.width(30.dp))
            Column {
                Text(
                    text = item.title,
                    fontFamily = gilroy,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF181725)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = item.description,
                    fontFamily = gilroy,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7C7C7C)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GroceryCartButton(
                        onClick = {
                            if (count > 1) {
                                onMinusChange()
                            }
                        },
                        backgroundColor = Color.Transparent,
                        icon = R.drawable.ic_minus,
                        isDisabled = count < 2,
                        isOutlined = true,
                        contentColor = Primary
                    )
                    Spacer(modifier = Modifier.width(17.dp))
                    Text(
                        text = count.toString(),
                        fontFamily = gilroy,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF181725)
                    )
                    Spacer(modifier = Modifier.width(17.dp))
                    GroceryCartButton(
                        onClick = {
                            if (count < 100) {
                                onPlusChange()
                            }
                        },
                        backgroundColor = Color.Transparent,
                        icon = R.drawable.ic_add,
                        isDisabled = count > 99,
                        isOutlined = true,
                        contentColor = Primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemComponentPreview() {
    var count by remember { mutableStateOf(1) }

    Box(modifier = Modifier.padding(24.dp)) {
        CartItemComponent(
            count = count,
            onMinusChange = {
                count--
            },
            onPlusChange = {
                count++
            }
        )
    }
}
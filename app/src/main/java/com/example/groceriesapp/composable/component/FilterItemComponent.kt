package com.example.groceriesapp.composable.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceriesapp.R
import com.example.groceriesapp.app.NoRippleTheme
import com.example.groceriesapp.model.dto.FilterItem
import com.example.groceriesapp.ui.theme.Primary
import com.example.groceriesapp.ui.theme.filterItemStyle

@Composable
fun FilterItemComponent(
    item: FilterItem = FilterItem(title = "Eggs", checked = false)
) {
    var checked by remember { mutableStateOf(item.checked) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        GroceryCheckBox(
            checked = checked,
            onCheckedChange = {
                checked = !checked
            }
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = item.title,
            style = filterItemStyle.copy(color = if (checked) Primary else Color(0xFF181725))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FilterItemComponentPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        FilterItemComponent()
    }
}

@Composable
fun GroceryCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: () -> Unit
) {
    val color = animateColorAsState(
        targetValue = if (checked) Primary else Color(0xFFFCFCFC)
    )
    Surface(
        modifier = modifier.clickable(
            MutableInteractionSource(), null, onClick = {
                onCheckedChange()
            }
        ),
        shape = RoundedCornerShape(8.dp),
        color = color.value,
        border = if (checked) null else BorderStroke(1.5.dp, Color(0xFFB1B1B1))
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_checkmark),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 7.dp)
                .alpha(if (checked) 1f else 0f),
            tint = Color(0xFFFCFCFC),
        )
    }
}
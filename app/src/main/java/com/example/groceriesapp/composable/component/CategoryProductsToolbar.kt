package com.example.groceriesapp.composable.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groceriesapp.R
import com.example.groceriesapp.ui.theme.screenTitleStyle

@Composable
fun CategoryProductToolbar(
    title: String = "Beverages",
    onBackArrowClick: () -> Unit = {},
    onFilterClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_navigation_arrow),
            contentDescription = null,
            modifier = Modifier.clickable {
                onBackArrowClick()
            }
        )
        Text(
            text = title,
            style = screenTitleStyle,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = null,
            modifier = Modifier.clickable {
                onFilterClick()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryProductToolBarPreview() {
    CategoryProductToolbar()
}


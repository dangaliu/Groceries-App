package com.example.groceriesapp.composable.screen.filter.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groceriesapp.R
import com.example.groceriesapp.composable.component.FilterItemComponent
import com.example.groceriesapp.composable.component.GroceryButton
import com.example.groceriesapp.composable.screen.filter.viewmodel.FilterViewModel
import com.example.groceriesapp.ui.theme.screenTitleStyle

@Composable
fun FilterScreen(
    navController: NavHostController,
    viewModel: FilterViewModel = hiltViewModel()
) {
    val categories = viewModel.categories
    val brand = viewModel.brand

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )
            Text(
                text = "Filter",
                style = screenTitleStyle,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                modifier = Modifier.alpha(0f)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF2F3F2),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 24.dp, top = 30.dp, end = 24.dp, bottom = 40.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Categories",
                    style = screenTitleStyle.copy(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(25.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    items(categories.size) { i ->
                        val category = categories[i]
                        FilterItemComponent(category)
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Brand",
                    style = screenTitleStyle.copy(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(25.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    items(brand.size) { i ->
                        val brandItem = brand[i]
                        FilterItemComponent(brandItem)
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                GroceryButton(
                    text = "Apply Filter",
                    onClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
    FilterScreen(navController = rememberNavController())
}
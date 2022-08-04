package com.example.groceriesapp.composable.screen.bottombar.explore.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.groceriesapp.composable.component.GroceryCategoryComponent
import com.example.groceriesapp.composable.component.GroceryProductCategory
import com.example.groceriesapp.composable.component.GrocerySearchComponent
import com.example.groceriesapp.composable.screen.bottombar.explore.viewmodel.ExploreViewModel
import com.example.groceriesapp.ui.theme.screenTitleStyle

@Composable
fun ExploreScreen(
    navController: NavHostController,
    viewModel: ExploreViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var search by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Find products",
            style = screenTitleStyle
        )
        Spacer(modifier = Modifier.height(30.dp))
        GrocerySearchComponent(
            value = search,
            onValueChange = {
                search = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), content = {
                items(viewModel.categories.size) { i ->
                    val category = viewModel.categories[i]
                    GroceryProductCategory(item = category)
                }
            },
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        )
    }
}
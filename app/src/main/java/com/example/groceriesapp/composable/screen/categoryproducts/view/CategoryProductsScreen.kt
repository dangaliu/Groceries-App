package com.example.groceriesapp.composable.screen.categoryproducts.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.groceriesapp.composable.component.CategoryProductToolbar
import com.example.groceriesapp.composable.component.GroceryItemComponent
import com.example.groceriesapp.composable.screen.categoryproducts.viewmodel.CategoryProductsViewModel

@Composable
fun CategoryProductsScreen(
    navController: NavHostController,
    viewModel: CategoryProductsViewModel = hiltViewModel(),
    categoryName: String = "Beverages"
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
    ) {
        val products = viewModel.categories.find { it.categoryTitle == categoryName }?.products

        Spacer(modifier = Modifier.height(15.dp))
        CategoryProductToolbar()
        Spacer(modifier = Modifier.height(30.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), content = {
                products?.let {
                    items(it.size) { i ->
                        val product = it[i]
                        GroceryItemComponent(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(249.dp),
                            item = product
                        )
                    }
                }
            },
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        )
    }
}
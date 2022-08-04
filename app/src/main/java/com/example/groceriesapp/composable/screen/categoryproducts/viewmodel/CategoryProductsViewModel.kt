package com.example.groceriesapp.composable.screen.categoryproducts.viewmodel

import androidx.lifecycle.ViewModel
import com.example.groceriesapp.R
import com.example.groceriesapp.model.dto.GroceryCategory
import com.example.groceriesapp.model.dto.GroceryComponentItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryProductsViewModel @Inject constructor(): ViewModel() {

    val categories = listOf(
        GroceryCategory(
            categoryTitle = "Beverages",
            products = mutableListOf(
                GroceryComponentItem(
                    image = R.drawable.diet_coke,
                    title = "Diet Coke",
                    description = "355ml, Price",
                    price = "\$1.99"
                ),
                GroceryComponentItem(
                    image = R.drawable.sprite_can,
                    title = "Sprite Can",
                    description = "325ml, Price",
                    price = "\$1.50"
                ),
                GroceryComponentItem(
                    image = R.drawable.apple_grape_juice,
                    title = "Apple & Grape \n" +
                            "Juice",
                    description = "2L, Price",
                    price = "\$15.99"
                ),
                GroceryComponentItem(
                    image = R.drawable.orange_juice,
                    title = "Orange Juice",
                    description = "2L, Price",
                    price = "\$15.99"
                ),
                GroceryComponentItem(
                    image = R.drawable.coca_cola_can,
                    title = "Coca Cola Can",
                    description = "325ml, Price",
                    price = "\$4.99"
                ),
                GroceryComponentItem(
                    image = R.drawable.pepsi_can,
                    title = "Pepsi Can",
                    description = "330ml, Price",
                    price = "\$4.99"
                )
            )
        )
    )

}
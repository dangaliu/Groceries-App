package com.example.groceriesapp.composable.screen.bottombar.explore.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.groceriesapp.R
import com.example.groceriesapp.model.dto.GroceryProductCategoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor() : ViewModel() {
    val categories = listOf(
        GroceryProductCategoryItem(
            title = "Frash Fruits\n" +
                    "& Vegetable",
            image = R.drawable.fruits_vegetable,
            color = Color(0xFF53B175)
        ),
        GroceryProductCategoryItem(
            title = "Cooking Oil\n" +
                    "& Ghee",
            image = R.drawable.cooking_oil_ghee,
            color = Color(0xFFF8A44C)
        ),
        GroceryProductCategoryItem(
            title = "Meat & Fish",
            image = R.drawable.meat_fish,
            color = Color(0xFFF7A593)
        ),
        GroceryProductCategoryItem(
            title = "Bakery & Snacks",
            image = R.drawable.bakery_snacks,
            color = Color(0xFFD3B0E0)
        ),
        GroceryProductCategoryItem(
            title = "Dairy & Eggs",
            image = R.drawable.dairy_eggs,
            color = Color(0xFFFDE598)
        ),
        GroceryProductCategoryItem(
            title = "Beverages",
            image = R.drawable.beverages,
            color = Color(0xFFB7DFF5)
        ),
        GroceryProductCategoryItem(
            title = "Frash Fruits\n" +
                    "& Vegetable",
            image = R.drawable.fruits_vegetable,
            color = Color(0xFF53B175)
        ),
        GroceryProductCategoryItem(
            title = "Cooking Oil\n" +
                    "& Ghee",
            image = R.drawable.cooking_oil_ghee,
            color = Color(0xFFF8A44C)
        ),
        GroceryProductCategoryItem(
            title = "Meat & Fish",
            image = R.drawable.meat_fish,
            color = Color(0xFFF7A593)
        ),
        GroceryProductCategoryItem(
            title = "Bakery & Snacks",
            image = R.drawable.bakery_snacks,
            color = Color(0xFFD3B0E0)
        ),
        GroceryProductCategoryItem(
            title = "Dairy & Eggs",
            image = R.drawable.dairy_eggs,
            color = Color(0xFFFDE598)
        ),
        GroceryProductCategoryItem(
            title = "Beverages",
            image = R.drawable.beverages,
            color = Color(0xFFB7DFF5)
        )
    )
}
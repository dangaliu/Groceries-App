package com.example.groceriesapp.model.dto

data class GroceryCategory(
    val categoryTitle: String,
    val products: MutableList<GroceryComponentItem>
)

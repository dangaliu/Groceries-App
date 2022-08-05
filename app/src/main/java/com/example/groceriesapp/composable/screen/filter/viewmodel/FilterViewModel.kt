package com.example.groceriesapp.composable.screen.filter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.groceriesapp.model.dto.FilterItem
import javax.inject.Inject

class FilterViewModel @Inject constructor() : ViewModel() {

    val categories = listOf(
        FilterItem(title = "Eggs", checked = false),
        FilterItem(title = "Noodles & Pasta", checked = false),
        FilterItem(title = "Chip & Crisps", checked = false),
        FilterItem(title = "Fast Food", checked = false)
    )

    val brand = listOf(
        FilterItem(title = "Individual Callection", checked = false),
        FilterItem(title = "Cocola", checked = false),
        FilterItem(title = "Ifad", checked = false),
        FilterItem(title = "Kazi Farmas", checked = false)
    )
}
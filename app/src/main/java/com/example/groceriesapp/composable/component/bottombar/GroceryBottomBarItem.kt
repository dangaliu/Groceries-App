package com.example.groceriesapp.composable.component.bottombar

import com.example.groceriesapp.R
import com.example.groceriesapp.navigation.NavConstants

sealed class GroceryBottomBarItem(val title: String, val icon: Int, val route: String) {
    object Shop : GroceryBottomBarItem("Shop", R.drawable.ic_shop, NavConstants.shop)
    object Explore : GroceryBottomBarItem("Explore", R.drawable.ic_explore, NavConstants.explore)
    object Cart: GroceryBottomBarItem("Cart", R.drawable.ic_cart, NavConstants.cart)
    object Favourite: GroceryBottomBarItem("Favourite", R.drawable.ic_favourite, NavConstants.favourite)
    object Account: GroceryBottomBarItem("Account", R.drawable.ic_account, NavConstants.account)
}

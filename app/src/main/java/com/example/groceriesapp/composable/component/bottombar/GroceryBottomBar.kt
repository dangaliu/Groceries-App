package com.example.groceriesapp.composable.component.bottombar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.groceriesapp.navigation.NavConstants
import com.example.groceriesapp.ui.theme.Primary
import com.example.groceriesapp.ui.theme.gilroy

@Composable
fun GroceryBottomBar(
    navController: NavHostController,
) {
    val items = listOf(
        GroceryBottomBarItem.Shop,
        GroceryBottomBarItem.Explore,
        GroceryBottomBarItem.Cart,
        GroceryBottomBarItem.Favourite,
        GroceryBottomBarItem.Account
    )

    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState().value
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(NavConstants.shop) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        tint = if (selected) Primary else Color(0xFF181725)
                    )
                },
                label = {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = item.title,
                            fontFamily = gilroy,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (selected) Primary else Color(0xFF181725),
                            maxLines = 1
                        )
                    }
                }
            )

//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center,
//                modifier = Modifier.clickable {
//                    navController.navigate(item.route) {
//                        popUpTo(NavConstants.shop) {
//                            saveState = true
//                        }
//
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            ) {
//                Icon(
//                    painter = painterResource(item.icon),
//                    contentDescription = null,
//                    tint = if (selected) Primary else Color(0xFF181725)
//                )
//                Spacer(modifier = Modifier.height(3.dp))
//                Text(
//                    text = item.title,
//                    fontFamily = gilroy,
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = if (selected) Primary else Color(0xFF181725)
//                )
//            }
        }
    }
}
package com.example.groceriesapp.composable.screen.bottombar.shop.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groceriesapp.R
import com.example.groceriesapp.composable.component.GroceryCategoryComponent
import com.example.groceriesapp.composable.component.GroceryItemComponent
import com.example.groceriesapp.composable.component.GrocerySearchComponent
import com.example.groceriesapp.composable.screen.bottombar.shop.viewmodel.ShopViewModel
import com.example.groceriesapp.ui.theme.Primary
import com.example.groceriesapp.ui.theme.gilroy
import com.example.groceriesapp.ui.theme.subTitleStyle
import com.example.groceriesapp.ui.theme.titleStyle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShopScreen(
    navController: NavHostController,
    shopViewModel: ShopViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_color_logo_without_text),
            contentDescription = "logo",
            modifier = Modifier
                .size(27.dp, 31.dp)
                .align(Alignment.CenterHorizontally),
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_location_marker),
                contentDescription = "marker",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(9.dp))
            Text(
                text = "Dhaka, Banassre",
                fontFamily = gilroy,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4C4F4D)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        GrocerySearchComponent(
            value = search,
            onValueChange = {
                search = it
            },
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(52.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Surface(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(115.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            val pagerState = rememberPagerState()
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                HorizontalPager(count = 3, state = pagerState) {
                    Image(
                        painter = painterResource(id = R.drawable.phone_auth_background),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = Primary,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .align(Alignment.BottomCenter)
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Exclusive Offer",
                style = titleStyle.copy(fontSize = 24.sp, color = Color(0xFF181725)),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Sell all",
                    style = subTitleStyle.copy(color = Primary, fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.clickable {

                        }
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(7) {
                GroceryItemComponent()
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Best Selling",
                style = titleStyle.copy(fontSize = 24.sp, color = Color(0xFF181725)),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Sell all",
                    style = subTitleStyle.copy(color = Primary, fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.clickable {

                    }
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(7) {
                GroceryItemComponent()
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Groceries",
                style = titleStyle.copy(fontSize = 24.sp, color = Color(0xFF181725)),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Sell all",
                    style = subTitleStyle.copy(color = Primary, fontWeight = FontWeight.SemiBold),
                    modifier = Modifier.clickable {

                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(7) {
                GroceryCategoryComponent()
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(7) {
                GroceryItemComponent()
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ShopScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ShopScreen(navController = rememberNavController())
    }
}
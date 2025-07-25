package com.sellink.app.presentation.screen

import CustomNavBar
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sellink.app.data.SelectedNavItem
import com.sellink.app.domain.models.Good
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import com.sellink.app.presentation.component.AddGoodItem
import com.sellink.app.presentation.component.GoodItem
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreScreen(
    onOrderNavClick: () -> Unit,
    onStoreNavClick: () -> Unit,
    onHomeNavClick: () -> Unit,
    categories: StateFlow<List<String>>,
    goods: StateFlow<List<Good>>,
    onGoodItemClick: (Good) -> Unit,
    onAddGoodItemClick: (String) -> Unit
) {
    val categoryList = categories.collectAsState()
    val goodsList = goods.collectAsState()

    LaunchedEffect(Unit) {
        println("Categories: ${categoryList.value}")
        println("Goods: ${goodsList.value}")
    }

    Scaffold(
        modifier = Modifier
            .fillMaxWidth(),
        bottomBar = {
            CustomNavBar(
                SelectedNavItem.StoreRoute,
                onOrderNavClick,
                onHomeNavClick,
                onStoreNavClick
            )
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFD9CAB3)
                )
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
            )
            Text( //Name of Store
                text = "Your Store",
                fontSize = 40.sp,
                color = Color(0xFF212121),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .border(
                        width = 0.5.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(0.dp)
                    )
                    .padding(start = 20.dp, end = 1.dp)
            ){
                items(categoryList.value) { category ->
                    Column(
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 10.dp)
                    ){
                        Text(
                            text = category,
                            color = Color(0xFF212121),
                            fontSize = 24.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 3.dp)
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            FlowRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp),
                                maxItemsInEachRow = 2,
                                horizontalArrangement = Arrangement.Start,
                            ) {
                                getGoodsByCategory(category, goodsList.value).forEach { good ->
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(0.5f) //REMEBER THISIIDSIISISISISIS
                                            .border(
                                                width = 1.dp,
                                                color = Color.Transparent,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                    ) {
                                        GoodItem(
                                            good,
                                            onClick = { onGoodItemClick(good) }
                                        )
                                    }
                                }
                            }
                        }
                        HorizontalDivider(
                            color = Color(0xFF212121),
                            thickness = 2.dp,
                            modifier = Modifier
                                .padding(top = 20.dp, end = 20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoreScreenPreview() {
    // Create sample data
    val sampleCategories = MutableStateFlow(listOf<String>("Category1", "Category2", "Category3"))
    val sampleGoods = MutableStateFlow(
        listOf<Good>(
            Good(
                name = "Good1", price = 10.0,
                category = "Category1",
                currency = "IDR"
            ),
            Good(
                name = "Good3", price = 10.0,
                category = "Category1",
                currency = "IDR"
            ),
            Good(
                name = "Good3", price = 10.0,
                category = "Category1",
                currency = "IDR"
            ),
            Good(
                name = "Good3", price = 10.0,
                category = "Category1",
                currency = "IDR"
            ),
            Good(
                name = "Good2", price = 10.0,
                category = "Category2",
                currency = "IDR"
            )
        )
    )

    StoreScreen(
        onOrderNavClick = { /* Handle Order Navigation */ },
        onStoreNavClick = { /* Handle Store Navigation */ },
        onHomeNavClick = { /* Handle Home Navigation */ },
        categories = sampleCategories,
        goods = sampleGoods,
        onGoodItemClick = {},
        onAddGoodItemClick = {}
    )
}

fun getGoodsByCategory(category: String, goods: List<Good>): List<Good> {
    val filteredGoods =  mutableListOf<Good>()

    Log.d("GOODS STATUS", "is it? " + goods.isEmpty())

    for (good in goods){
        println(good.category + " : " + category)
        if (good.category.equals(category)){
            filteredGoods.add(good)
        }
    }

    Log.d("GoodsFilter", "Category: $category, Goods: $filteredGoods")
    return filteredGoods
}

fun getGoodsByCategorySize(category: String, goods: List<Good>): Int {
    return getGoodsByCategory(category, goods).size
}
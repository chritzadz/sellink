package com.sellink.app.presentation.screen

import CustomNavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sellink.app.data.SelectedNavItem
import com.sellink.app.domain.models.Good
import com.sellink.app.domain.models.Order
import com.sellink.app.presentation.component.OrderList

@Composable
fun OrderScreen(
    modifier: Modifier = Modifier,
    onOrderNavClick: () -> Unit,
    onStoreNavClick: () -> Unit,
    onHomeNavClick: () -> Unit
) {
    val tempOrderList: List<Order> = listOf(
        Order(101010, "Order1", listOf(
            Good("good1", 50000.0)
        )),
        Order(101010, "Order1", listOf(
            Good("good1", 50000.0)
        ))
    )

    Scaffold(
        modifier = Modifier,
        bottomBar = {
            CustomNavBar(
                SelectedNavItem.OrderRoute,
                onOrderNavClick,
                onHomeNavClick,
                onStoreNavClick
            )
        }
    ) { innerPadding ->
        Column( //Screen
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Box( //Upper Navigation (Ongoing and Completed)
                modifier = Modifier
                    .height(50.dp)
                    .background(Color.Green)
                    .padding(top = 10.dp)
            ){
                Row( //Ongoing and Completed horizontal layout
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box( //Ongoing Box
                        modifier = Modifier
                            .weight(1f)
                            .height(25.dp)
                            .background(Color.Blue)
                    ) {
                        Text(
                            text = "Ongoing",
                            modifier = Modifier
                                .align(Alignment.Center),
                        )
                    }
                    Box( //Completed Box
                        modifier = Modifier
                            .weight(1f)
                            .height(25.dp)
                            .background(Color.Red)
                    ) {
                        Text(
                            text = "Completed",
                            modifier = Modifier
                                .align(Alignment.Center),
                        )
                    }
                }
            }
            OrderList(tempOrderList)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderScreenPreview() {
    OrderScreen(
        modifier = Modifier
            .fillMaxSize(),
        onOrderNavClick = { /* Handle Order Navigation */ },
        onStoreNavClick = { /* Handle Store Navigation */ },
        onHomeNavClick = { /* Handle Home Navigation */ }
    )
}

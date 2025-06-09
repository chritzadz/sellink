package com.sellink.app.presentation.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sellink.app.domain.models.Good
import com.sellink.app.domain.models.Order

@Composable
fun OrderList(orders: List<Order>) {
    LazyColumn {
        items(orders) { order ->
            OrderItem(order);
        }
    }
}

@Preview
@Composable
fun OrderListPreview(){
    OrderList(
        listOf(
            Order(101010, "Order1", listOf(
                Good("good1", 50000.0)
            )),
            Order(101010, "Order1", listOf(
                Good("good1", 50000.0)
            ))
        )
    )
}


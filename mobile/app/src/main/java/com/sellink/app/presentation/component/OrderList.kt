package com.sellink.app.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sellink.app.domain.models.Good
import com.sellink.app.domain.models.Order

@Composable
fun OrderList(orders: List<Order>) {
    LazyColumn (

    ){
        items(orders) { order ->
            OrderItem(order);
        }
    }
}

@Preview
@Composable
fun OrderListPreview(){

}


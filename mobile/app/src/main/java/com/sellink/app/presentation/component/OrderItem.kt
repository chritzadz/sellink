package com.sellink.app.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sellink.app.domain.models.Good
import com.sellink.app.domain.models.Order

@Composable
fun OrderItem(order: Order) {
    Box(
        modifier = Modifier
            .padding(top = 2.5.dp, bottom = 2.5.dp, start = 5.dp, end = 5.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .height(60.dp)
            .background(Color(0xFF09879B))
            .clickable {
                println("CLICKED")
            }
    ){
        Column (
            modifier = Modifier
                .padding(start = 10.dp)
                .align(Alignment.CenterStart)
        ) {
            Box(
                modifier = Modifier
                    .height(18.dp)
                    .background(Color(0xFFC40000))
            ) {
                Text(
                    fontSize = 13.sp,
                    text = "Order #" + order.id.toString()
                )
            }
            Box(
                modifier = Modifier
                    .height(18.dp)
                    .background(Color(0xFFC40000))
            ) {
                Text(
                    fontSize = 13.sp,
                    text = "Total: IDR " + order.total.toString()
                )
            }
            Box(
                modifier = Modifier
                    .height(18.dp)
                    .background(Color(0xFFC40000))
            ) {
                Text(
                    fontSize = 13.sp,
                    text = "Status: " + order.status
                )
            }
        }
    }
}

@Preview
@Composable
fun OrderItemPreview(){

}
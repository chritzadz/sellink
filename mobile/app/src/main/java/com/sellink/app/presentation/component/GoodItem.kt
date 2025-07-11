package com.sellink.app.presentation.component

import android.content.Intent
import android.view.RoundedCorner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.sellink.app.R
import com.sellink.app.domain.models.Good

@Composable
fun GoodItem(
    good: Good,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .height(180.dp)
            .clickable(onClick = onClick)
    ){
        Column{
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
            )
            Text(
                text = good.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 1.em,
                modifier = Modifier
                    .padding(top = 3.dp, start = 5.dp, end = 5.dp)

            )
            Text(
                text = "This is the description of the product",
                fontSize = 10.sp,
                lineHeight = 1.em,
                modifier = Modifier
                    .padding(top = 2.dp, start = 5.dp, end = 5.dp)
                    .height(23.dp)
            )
            Row (
                modifier = Modifier
                    .padding(top = 2.dp, start = 5.dp, end = 5.dp)

            ){
                Text(
                    text = "${good.currency} ${good.price}",
                    fontSize = 10.sp,
                    lineHeight = 1.em,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoodItemPreview(){
    GoodItem(
        Good(
            name = "Good3", price = 10000.0,
            category = "Category1",
            currency = "IDR"
        ),
        onClick = {}
    )
}

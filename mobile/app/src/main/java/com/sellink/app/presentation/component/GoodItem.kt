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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
            .padding(bottom = 20.dp, end = 20.dp)
            .wrapContentHeight()
            .clickable(onClick = onClick)
            .border(
                1.dp, Color.Transparent
            )
    ){
        Column{
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .height(80.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.jpg_44),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
            Text(
                text = good.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 1.em,
                modifier = Modifier
                    .padding(top = 3.dp)
            )
            Text(
                text = "This is the description of the product, This will showcase the",
                fontSize = 12.sp,
                lineHeight = 1.em,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .height(25.dp)
            )
            Row (
                modifier = Modifier
                    .padding(top = 3.dp)

            ){
                Text(
                    text = "${good.currency} ${good.price}",
                    fontSize = 16.sp,
                    lineHeight = 1.em,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 3.dp)
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

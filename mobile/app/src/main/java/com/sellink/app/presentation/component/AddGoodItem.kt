package com.sellink.app.presentation.component

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sellink.app.R
import com.sellink.app.domain.models.Order

@Composable
fun AddGoodItem(

) {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(115.dp)
            .background(Color.White)
            .border(
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp)
            )
            .clickable(){

            }

    ){
        Image(
            painter = painterResource(id = R.drawable.plus_logo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .height(65.dp)
                .clip(
                    shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp)
                )
        )
    }
}

@Preview
@Composable
fun AddGoodItemPreview(){
    AddGoodItem()
}
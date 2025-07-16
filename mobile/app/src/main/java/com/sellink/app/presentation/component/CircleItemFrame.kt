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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sellink.app.R
import com.sellink.app.domain.models.Order

@Composable
fun CircleItemFrame(
    modifier: Modifier,
    image: Painter,
    onClick: () -> Unit,
    color: Color
) {
    Box(
        modifier = modifier
            .background(color, shape = CircleShape)
            .border(
                width = 2.dp,
                color = Color.Black,
                shape = CircleShape
            )
            .clickable(
                onClick = onClick
            )
            .padding(10.dp)

    ){
        Image(
            painter = image,
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
fun CircleItemFramePreview(){
    CircleItemFrame(
        image = painterResource(id = R.drawable.plus_logo),
        modifier = Modifier
            .size(100.dp),
        onClick = {},
        color = Color.White
    )
}
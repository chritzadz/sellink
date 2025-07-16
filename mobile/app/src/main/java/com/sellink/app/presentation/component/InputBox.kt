package com.sellink.app.presentation.component

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sellink.app.presentation.screen.shadow

@Composable
fun InputBox(
    modifier: Modifier, //for height and width
    text: String
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .border( 2.dp, Color.Black, RoundedCornerShape(10.dp))
    ){
        TextField(
            value = "",
            onValueChange = {  },
            label = { BasicText(
                text = text,
                autoSize = TextAutoSize.StepBased(
                    minFontSize = 10.sp,
                    maxFontSize = 20.sp
                ),
                color = ColorProducer { Color(0xFFA6A6A6) }
            ) },
            modifier = Modifier
                .background(
                    Color(0xFFD9CAB3)
                )
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun InputBoxPreview(){
    InputBox(
        modifier = Modifier
            .width(200.dp)
            .wrapContentHeight(),
        text = "Input name"
    )
}
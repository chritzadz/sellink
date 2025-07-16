package com.sellink.app.presentation.screen

import CustomNavBar
import android.graphics.BlurMaskFilter
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.sellink.app.R
import com.sellink.app.presentation.component.AddGoodItem
import com.sellink.app.presentation.component.CircleItemFrame
import com.sellink.app.presentation.component.GoodItem
import com.sellink.app.presentation.component.InputBox
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    modifier: Modifier
) {
//    val storeName =
//    val email =
//    val password =

    LaunchedEffect(Unit) {

    }

    //design here
    Scaffold(
        modifier = modifier
            .background(Color(0xFFD9CAB3)),
        contentWindowInsets = WindowInsets(0.dp)
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color(0xFFD9CAB3))
        ){
            Box(
                modifier = Modifier
                    .padding(top = 100.dp)
            ){
                Text(
                    text = "Sign Up",
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
            Column(
                modifier = Modifier
                    .padding(top = 50.dp, start = 40.dp, end = 40.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .padding(top = 30.dp)
                ){
                    Box(
                        modifier = Modifier
                            .shadow(
                                color = Color(0xFF6D9886),
                                spread = 3.dp,
                                blurRadius = 10.dp
                            )
                    ){
                        InputBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            text = "Input username"
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 30.dp)
                ){
                    Box(
                        modifier = Modifier
                            .shadow(
                                color = Color(0xFF6D9886),
                                spread = 3.dp,
                                blurRadius = 10.dp
                            )
                    ){
                        InputBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            text = "Input password"
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .padding(top = 30.dp)
                ){
                    Box(
                        modifier = Modifier
                            .shadow(
                                color = Color(0xFF6D9886),
                                spread = 3.dp,
                                blurRadius = 10.dp
                            )
                    ){
                        InputBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            text = "Input store"
                        )
                    }
                }
                Button(
                    onClick = { /* TODO: Handle sign-up logic */ },
                    enabled = true,
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(2.dp, Color.Black),
                    contentPadding = PaddingValues(16.dp),
                    interactionSource = remember { MutableInteractionSource() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6D9886),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .weight(0.3f, fill = false)
                        .padding(top = 40.dp)
                ) {
                    Text(text = "Sign Up", color = Color.White)
                }
            }
            Box(
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp, top = 40.dp)
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally)
            ) { // for already have an account?
                Row(){
                    Text(
                        text = "Already have an account? ",
                        color = Color.Black,
                        modifier = Modifier
                    )
                    Text(
                        text = "Click here",
                        color = Color.Black,
                        modifier = Modifier
                            .clickable { /* Handle click here */ }
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp, top = 40.dp, bottom = 40.dp)
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    CircleItemFrame(
                        modifier = Modifier
                            .size(45.dp),
                        image = painterResource(id = R.drawable.google_logo),
                        color = Color.White,
                        onClick = {}
                    )
                    CircleItemFrame(
                        modifier = Modifier
                            .size(45.dp),
                        image = painterResource(id = R.drawable.google_logo),
                        color = Color.White,
                        onClick = {}
                    )
                    CircleItemFrame(
                        modifier = Modifier
                            .size(45.dp),
                        image = painterResource(id = R.drawable.google_logo),
                        color = Color.White,
                        onClick = {}
                    )
                }
            }
            HorizontalDivider(
                color = Color.Black,
                thickness = 2.dp,
                modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp)
            )
        }
    }
}

fun Modifier.shadow(
    color: Color = Color.Black,
    borderRadius: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0f.dp,
    modifier: Modifier = Modifier
) = this.then(
    modifier.drawBehind {
        this.drawIntoCanvas {
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            val spreadPixel = spread.toPx()
            val leftPixel = (0f - spreadPixel) + offsetX.toPx()
            val topPixel = (0f - spreadPixel) + offsetY.toPx()
            val rightPixel = (this.size.width + spreadPixel)
            val bottomPixel = (this.size.height + spreadPixel)

            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
            }

            frameworkPaint.color = color.toArgb()
            it.drawRoundRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                radiusX = borderRadius.toPx(),
                radiusY = borderRadius.toPx(),
                paint
            )
        }
    }
)

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen(
        modifier = Modifier.padding(0.dp)
    )
}

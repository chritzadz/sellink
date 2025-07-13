package com.sellink.app.presentation.screen

import CustomNavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.ScaffoldDefaults.contentWindowInsets
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    onOrderNavClick: () -> Unit,
    onStoreNavClick: () -> Unit,
    onHomeNavClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            CustomNavBar(
                SelectedNavItem.OrderRoute,
                onOrderNavClick,
                onHomeNavClick,
                onStoreNavClick
            )
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column( //Screen
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .background(Color(0xFFF2E7D5))
        ) {
            Box( //Spacing for notification
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF6D9886))
                    .height(50.dp)
            )
            Box( //Upper Navigation (Ongoing and Completed)
                modifier = Modifier
                    .height(40.dp)
                    .background(Color(0xFF6D9886))
            ){
                Row( //Ongoing and Completed horizontal layout
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box( //Ongoing Box
                        modifier = Modifier
                            .weight(1f)
                            .height(40.dp)
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
                            .height(40.dp)
                    ) {
                        Text(
                            text = "Completed",
                            modifier = Modifier
                                .align(Alignment.Center),
                        )
                    }
                }
            }
            //OrderList(tempOrderList)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderScreenPreview() {
    OrderScreen(
        onOrderNavClick = { /* Handle Order Navigation */ },
        onStoreNavClick = { /* Handle Store Navigation */ },
        onHomeNavClick = { /* Handle Home Navigation */ }
    )
}

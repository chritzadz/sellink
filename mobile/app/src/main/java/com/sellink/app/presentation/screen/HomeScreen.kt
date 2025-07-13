package com.sellink.app.presentation.screen

import CustomNavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sellink.app.data.SelectedNavItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onOrderNavClick: () -> Unit,
    onStoreNavClick: () -> Unit,
    onHomeNavClick: () -> Unit
) {
    Scaffold(
        modifier = modifier
            .background(
                Color(0xFFF6F6F6)
            ),
        bottomBar = {
            CustomNavBar(
                SelectedNavItem.HomeRoute,
                onOrderNavClick,
                onHomeNavClick,
                onStoreNavClick
            )
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .background(
                    Color(0xFFF6F6F6)
                )
                .fillMaxWidth()
                .height(100.dp)
        ){
            Box(){

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize(),
        onOrderNavClick = { /* Handle Order Navigation */ },
        onStoreNavClick = { /* Handle Store Navigation */ },
        onHomeNavClick = { /* Handle Home Navigation */ }
    )
}

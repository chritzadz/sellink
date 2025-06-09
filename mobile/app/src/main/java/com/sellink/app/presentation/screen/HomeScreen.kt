package com.sellink.app.presentation.screen

import CustomNavBar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sellink.app.data.SelectedNavItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onOrderNavClick: () -> Unit,
    onStoreNavClick: () -> Unit,
    onHomeNavClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            CustomNavBar(
                SelectedNavItem.HomeRoute,
                onOrderNavClick,
                onHomeNavClick,
                onStoreNavClick
            )
        }
    ) { innerPadding ->
        Text(
            text = "HomeScreen",
            modifier = modifier
                .padding(innerPadding)
        )
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

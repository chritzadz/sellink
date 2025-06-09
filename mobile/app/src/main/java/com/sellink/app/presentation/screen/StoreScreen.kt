package com.sellink.app.presentation.screen

import CustomNavBar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sellink.app.presentation.component.SelectedNavItem

@Composable
fun StoreScreen(
    modifier: Modifier = Modifier,
    onOrderNavClick: () -> Unit,
    onStoreNavClick: () -> Unit,
    onHomeNavClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            CustomNavBar(
                SelectedNavItem.StoreRoute,
                onOrderNavClick,
                onHomeNavClick,
                onStoreNavClick
            )
        }
    ) { innerPadding ->
        Text(
            text = "StoreScreen",
            modifier = modifier
                .padding(innerPadding)
        )
    }
}
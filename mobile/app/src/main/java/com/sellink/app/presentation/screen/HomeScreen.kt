package com.sellink.app.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(100) {
            Text("Note $it")
        }
    }
}
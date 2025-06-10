package com.sellink.app.presentation.screen

import CustomNavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import com.sellink.app.data.Database
import com.sellink.app.data.SelectedNavItem
import com.sellink.app.domain.models.Good
import com.sellink.app.domain.models.Order
import com.sellink.app.domain.usecase.GoodUseCase
import com.sellink.app.domain.usecase.OrderUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch

private fun GoodUseCase.addGood(
    good: Good,
    string: String,
    value: Any
) {
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoreScreen(
    onOrderNavClick: () -> Unit,
    onStoreNavClick: () -> Unit,
    onHomeNavClick: () -> Unit
) {
    var goodUseCase: GoodUseCase = GoodUseCase()
    var orderUseCase: OrderUseCase = OrderUseCase()

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .fillMaxWidth(),
        bottomBar = {
            CustomNavBar(
                SelectedNavItem.StoreRoute,
                onOrderNavClick,
                onHomeNavClick,
                onStoreNavClick
            )
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .background(Color.Green)
        ){
            Text(
                text = "StoreScreen",
                modifier = Modifier
                    .padding(innerPadding)
            )
            Button(
                modifier = Modifier,
                onClick = {
                    coroutineScope.launch {
                        goodUseCase.addGood(Good(
                            name = "GOOD1",
                            price= 50000.0,
                            currency = "IDR",
                            category = "Beverage"
                        ))
                    }
                }
            ){
                Text(
                    text = "add Good"
                )
            }
            Button(
                modifier = Modifier,
                onClick = {
                    println("CLCIKED")
                }
            ){
                Text(
                    text = "add Order"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StoreScreenPreview(){
    StoreScreen(
        onOrderNavClick = { /* Handle Order Navigation */ },
        onStoreNavClick = { /* Handle Store Navigation */ },
        onHomeNavClick = { /* Handle Home Navigation */ }
    )
}
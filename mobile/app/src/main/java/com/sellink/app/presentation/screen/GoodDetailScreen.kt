package com.sellink.app.presentation.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sellink.app.domain.models.Good

@Composable
fun GoodDetailScreen(
    modifier: Modifier = Modifier,
    good: Good,
    onBackButtonClick: () -> Unit,
    onUpdateButtonClick: (Good, Good) -> Unit
) {
    var name by remember { mutableStateOf(good.name) }
    var price by remember { mutableStateOf(good.price.toString()) }
    var category by remember { mutableStateOf(good.category) }
    var currency by remember { mutableStateOf(good.currency) }

    Scaffold(modifier = modifier) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Edit Good",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)

                )

            Spacer(modifier = Modifier.height(16.dp))

            // Card for displaying and editing the good
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Name: $name", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Edit Name") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Price: $price", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = price,
                        onValueChange = { price = it },
                        label = { Text("Edit Price") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Category: $category", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = category,
                        onValueChange = { category = it },
                        label = { Text("Edit Category") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Currency: $currency", style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = currency,
                        onValueChange = { currency = it },
                        label = { Text("Edit Currency") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row {
                        Button(
                            onClick = {
                                onUpdateButtonClick(
                                    good,
                                    Good(name, price.toDoubleOrNull() ?: 0.0, category, currency)
                                )
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Update")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(
                            onClick = onBackButtonClick,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Back")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoodDetailScreenPreview() {
    GoodDetailScreen(
        modifier = Modifier
            .fillMaxSize(),
        Good(
            name = "Good2", price = 10.0,
            category = "Category2",
            currency = "IDR"
        ),
        onBackButtonClick = {},
        onUpdateButtonClick = { good1, good2 ->
            TODO()
        }
    )
}

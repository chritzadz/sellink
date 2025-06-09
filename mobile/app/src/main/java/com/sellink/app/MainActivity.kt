package com.sellink.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.sellink.app.presentation.navigation.NavigationController
import com.sellink.app.presentation.screen.HomeScreenPreview
import com.sellink.app.presentation.theme.simpleTheme

class MainActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        setContent {
            simpleTheme {
                Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationController(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}


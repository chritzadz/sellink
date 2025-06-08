package com.sellink.app.presentation.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.sellink.app.presentation.screen.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreen: NavKey

@Composable
fun NavigationController (
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(HomeScreen)
    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
            rememberSceneSetupNavEntryDecorator()
        ),
        entryProvider =  { key ->
            when(key) {
                is HomeScreen -> {
                    NavEntry(
                        key = key,
                    ) {
                        HomeScreen()
                    }
                }
                else -> throw RuntimeException("Invalid Key Route")
            }
        }
    )
}
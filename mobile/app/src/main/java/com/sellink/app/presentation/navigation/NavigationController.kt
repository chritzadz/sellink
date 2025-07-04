package com.sellink.app.presentation.navigation
import StoreViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.sellink.app.domain.models.Good
import com.sellink.app.presentation.screen.AddGoodScreen
import com.sellink.app.presentation.screen.GoodDetailScreen
import com.sellink.app.presentation.screen.HomeScreen
import com.sellink.app.presentation.screen.OrderScreen
import com.sellink.app.presentation.screen.StoreScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeScreen: NavKey

@Serializable
data object OrderScreen: NavKey

@Serializable
data object StoreScreen: NavKey

@Serializable
data class EditGoodDetailScreen(val good: Good): NavKey

@Serializable
data class AddGoodScreen(val categoryFrom: String): NavKey

@Composable
fun NavigationController (
    modifier: Modifier = Modifier
) {
    val backStack = rememberNavBackStack(HomeScreen)
    val storeViewModel: StoreViewModel = viewModel()

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
                        HomeScreen(
                            onOrderNavClick = {
                                backStack.add(OrderScreen)
                            },
                            onHomeNavClick = {
                                backStack.add(HomeScreen)
                            },
                            onStoreNavClick = {
                                backStack.add(StoreScreen)
                            }
                        )
                    }
                }
                is OrderScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        OrderScreen(
                            onOrderNavClick = {
                                backStack.add(OrderScreen)
                            },
                            onHomeNavClick = {
                                backStack.add(HomeScreen)
                            },
                            onStoreNavClick = {
                                backStack.add(StoreScreen)
                            }
                        )
                    }
                }
                is StoreScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        StoreScreen(
                            onOrderNavClick = {
                                backStack.add(OrderScreen)
                            },
                            onHomeNavClick = {
                                backStack.add(HomeScreen)
                            },
                            onStoreNavClick = {
                                backStack.add(StoreScreen)
                            },
                            categories =
                                storeViewModel.categories,
                            goods =
                                storeViewModel.goods,
                            onGoodItemClick = { good ->
                                backStack.add(EditGoodDetailScreen(good))
                            },
                            onAddGoodItemClick = { category ->
                                backStack.add(AddGoodScreen(categoryFrom = category))
                            }
                        )
                    }
                }
                is EditGoodDetailScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        GoodDetailScreen(
                            good = key.good,
                            onBackButtonClick = {
                                backStack.add(StoreScreen)

                            },
                            onUpdateButtonClick = { old, new ->
                                storeViewModel.updateGood(old, new)
                                backStack.removeAt(backStack.size - 1)
                            }
                        )
                    }
                }
                is AddGoodScreen -> {
                    NavEntry(
                        key = key
                    ) {
                        AddGoodScreen(
                            onBackButtonClick = {
                                backStack.add(StoreScreen)
                            },
                            onAddButtonClick = { good ->
                                storeViewModel.addGood(good)
                                backStack.removeAt(backStack.size - 1)
                            },
                            categoryFrom = key.categoryFrom
                        )
                    }
                }
                else -> throw RuntimeException("Invalid Key Route")
            }
        },
        modifier = modifier
    )
}
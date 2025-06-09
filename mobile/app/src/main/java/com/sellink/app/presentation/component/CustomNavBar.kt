import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.graphics.Color
import com.sellink.app.presentation.component.SelectedNavItem


@Composable
fun CustomNavBar(
    selectedNavItem: String,
    onOrderNavClick: () -> Unit,
    onHomeNavClick: () -> Unit,
    onStoreNavClick: () -> Unit
) {
    NavigationBar(
        containerColor = Color(0xFFFFFFFF)
    ) {
        NavigationBarItem(
            selected = orderSelected(selectedNavItem),
            onClick = {
                onOrderNavClick()
            },
            icon = { Text("Order") },
        )
        NavigationBarItem(
            selected = homeSelected(selectedNavItem),
            onClick = {
                onHomeNavClick()
            },
            icon = { Text("Home") },
        )
        NavigationBarItem(
            selected = storeSelected(selectedNavItem),
            onClick = {
                onStoreNavClick()
            },
            icon = { Text("Store") },
        )
    }
}

fun homeSelected(selectedNavItem: String): Boolean{
    return selectedNavItem == SelectedNavItem.HomeRoute
}

fun orderSelected(selectedNavItem: String): Boolean{
    return selectedNavItem == SelectedNavItem.OrderRoute
}

fun storeSelected(selectedNavItem: String): Boolean{
    return selectedNavItem == SelectedNavItem.StoreRoute
}
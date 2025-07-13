import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.ui.graphics.Color
import com.sellink.app.data.SelectedNavItem


@Composable
fun CustomNavBar(
    selectedNavItem: String,
    onOrderNavClick: () -> Unit,
    onHomeNavClick: () -> Unit,
    onStoreNavClick: () -> Unit
) {
    NavigationBar(
        containerColor = Color(0xFF6D9886)
    ) {
        NavigationBarItem(
            selected = orderSelected(selectedNavItem),
            onClick = {
                onOrderNavClick()
            },
            icon = { Text("Order", color = if (orderSelected(selectedNavItem)) Color(0xFFF6F6F6) else Color(0xFF212121)) },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color(0xFFF6F6F6),
                unselectedTextColor = Color(0xFF212121),
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black,
                indicatorColor = Color(0xFFD9CAB3)
            )
        )
        NavigationBarItem(
            selected = homeSelected(selectedNavItem),
            onClick = {
                onHomeNavClick()
            },
            icon = { Text("Home", color = if (homeSelected(selectedNavItem)) Color(0xFFF6F6F6) else Color(0xFF212121)) },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color(0xFFF6F6F6),
                unselectedTextColor = Color(0xFF212121),
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black,
                indicatorColor = Color(0xFFD9CAB3)
            )
        )
        NavigationBarItem(
            selected = storeSelected(selectedNavItem),
            onClick = {
                onStoreNavClick()
            },
            icon = { Text("Store", color = if (storeSelected(selectedNavItem)) Color(0xFFF6F6F6) else Color(0xFF212121)) },
            colors = NavigationBarItemDefaults.colors(
                selectedTextColor = Color(0xFFF6F6F6),
                unselectedTextColor = Color(0xFF212121),
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Black,
                indicatorColor = Color(0xFFD9CAB3)
            ),
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
package sebag.florent.presentation.navigation

sealed class NavigationRoute(val route: String) {
    data object Home : NavigationRoute("home")
    data object Details : NavigationRoute("details/{itemId}") {
        fun createRoute(itemId: String) = "details/$itemId"
    }
}
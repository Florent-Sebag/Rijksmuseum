package sebag.florent.presentation.host

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
}
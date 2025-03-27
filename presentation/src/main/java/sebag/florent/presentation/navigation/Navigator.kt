package sebag.florent.presentation.navigation

import androidx.navigation.NavHostController

class Navigator(
    private val navController: NavHostController
) : NavigationHandler {
    override fun navigateTo(route: String) {
        navController.navigate(route)
    }

    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateWithPopUp(route: String, popUpRoute: String) {
        navController.navigate(route) {
            popUpTo(popUpRoute) { inclusive = true }
        }
    }
}
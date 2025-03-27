package sebag.florent.presentation.navigation

interface NavigationHandler {
    fun navigateTo(route: String)
    fun navigateBack()
    fun navigateWithPopUp(route: String, popUpRoute: String)
}
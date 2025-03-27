package sebag.florent.presentation.features.home

sealed class HomeAction {
    data object Retry : HomeAction()
}
package sebag.florent.presentation.features.home

sealed class HomeAction {
    data class OnItemClicked(val artId: String) : HomeAction()
}
package sebag.florent.presentation.features.details

sealed class DetailsAction {
    data object Retry : DetailsAction()
}
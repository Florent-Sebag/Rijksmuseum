package sebag.florent.presentation.features.home

import sebag.florent.presentation.model.ArtUiModel

sealed class HomeState {

    data object Loading : HomeState()
    data object Error: HomeState()
    data class Success(val artList: List<ArtUiModel>) : HomeState()
}
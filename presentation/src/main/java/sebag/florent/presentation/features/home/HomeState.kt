package sebag.florent.presentation.features.home

import sebag.florent.domain.model.ArtModel

sealed class HomeState {

    object Loading : HomeState()
    data class Success(val artList: List<ArtModel>) : HomeState()
    data class Error(val message: String) : HomeState()
}
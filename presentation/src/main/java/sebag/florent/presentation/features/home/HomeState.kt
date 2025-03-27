package sebag.florent.presentation.features.home

import sebag.florent.domain.model.ArtModel
import sebag.florent.presentation.model.ArtUiModel

sealed class HomeState {

    object Loading : HomeState()
    data class Success(val artList: List<ArtUiModel>) : HomeState()
    data class Error(val message: String) : HomeState()
}
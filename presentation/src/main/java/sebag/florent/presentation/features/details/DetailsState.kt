package sebag.florent.presentation.features.details

import sebag.florent.presentation.model.ArtUiModel

sealed class DetailsState {

    object Loading : DetailsState()
    data class Success(val art: ArtUiModel) : DetailsState()
    data class Error(val message: String) : DetailsState()
}
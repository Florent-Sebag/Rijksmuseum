package sebag.florent.presentation.features.details

import sebag.florent.presentation.model.ArtUiModel

sealed class DetailsState {

    data object Loading : DetailsState()
    data object Error : DetailsState()
    data class Success(val art: ArtUiModel) : DetailsState()
}
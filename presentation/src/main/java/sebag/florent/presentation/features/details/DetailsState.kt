package sebag.florent.presentation.features.details

import sebag.florent.presentation.features.commonui.model.ArtUiModel

sealed class DetailsState {

    data object Loading : DetailsState()
    data object Error : DetailsState()
    data class Success(val art: ArtUiModel) : DetailsState()
}
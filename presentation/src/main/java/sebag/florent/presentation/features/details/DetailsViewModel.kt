package sebag.florent.presentation.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sebag.florent.domain.usecases.GetArtDetailsUseCase
import sebag.florent.presentation.features.common.utils.toUiArtModel

class DetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getArtDetailsUseCase: GetArtDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsState>(DetailsState.Loading)
    val state = _state.asStateFlow()

    init {
        initDetails()
    }

    fun onAction(action: DetailsAction) {
        when (action) {
            is DetailsAction.Retry -> {
                initDetails()
            }
        }
    }

    private fun initDetails() {
        savedStateHandle.get<String>("itemId")?.let { itemId ->
            fetchArtDetails(itemId)
        } ?: updateState(DetailsState.Error)
    }

    private fun fetchArtDetails(itemId: String) {
        updateState(DetailsState.Loading)
        viewModelScope.launch {
            getArtDetailsUseCase(itemId).fold(
                onSuccess = { artDetails ->
                    updateState(DetailsState.Success(artDetails.toUiArtModel()))
                },
                onFailure = {
                    updateState(DetailsState.Error)
                }
            )
        }
    }

    private fun updateState(newState: DetailsState) {
        _state.value = newState
    }
}
package sebag.florent.presentation.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sebag.florent.domain.usecases.GetArtDetailsUseCase

class DetailsViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val getArtDetailsUseCase: GetArtDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<DetailsState>(DetailsState.Loading)
    val state = _state.asStateFlow()

    init {
        fetchArtDetails(savedStateHandle["itemId"])
    }

    private fun fetchArtDetails(itemId: String?) {
        viewModelScope.launch {

        }
    }

    fun onAction(action: DetailsAction) {

    }
}
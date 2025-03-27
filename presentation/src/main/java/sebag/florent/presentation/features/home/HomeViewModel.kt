package sebag.florent.presentation.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sebag.florent.domain.model.ArtModel
import sebag.florent.domain.usecases.GetArtListUseCase
import sebag.florent.presentation.model.ArtUiModel

class HomeViewModel(
    private val getArtListUseCase: GetArtListUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state = _state.asStateFlow()

    init {
        fetchArtList()
    }

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.Retry -> {
                fetchArtList()
            }
        }
    }

    private fun fetchArtList() {
        updateState(HomeState.Loading)
        viewModelScope.launch {
            getArtListUseCase(0, 15).fold(
                onSuccess = { artList ->
                    updateState(HomeState.Success(artList.map {
                        it.toUiArtModel()
                    }))
                },
                onFailure = {
                    updateState(HomeState.Error)
                }
            )
        }
    }

    private fun updateState(newState: HomeState) {
        _state.value = newState
    }

    private fun ArtModel.toUiArtModel() = ArtUiModel(
        id = this.id,
        title = this.title,
        imageUrl = this.imageUrl,
        artist = this.artist,
        description = null
    )
}
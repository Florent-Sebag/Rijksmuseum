package sebag.florent.presentation.features.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import sebag.florent.domain.usecases.GetArtListUseCase

class HomeViewModel(
    private val getArtListUseCase: GetArtListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState.Loading)
    val state = _state.asStateFlow()

    init {
        fetchArtList()
    }

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.OnItemClicked -> {

            }
        }
    }

    private fun fetchArtList() {

    }
}
package sebag.florent.presentation.features.home

import androidx.compose.runtime.Composable
import sebag.florent.presentation.features.common.ui.ErrorComposable
import sebag.florent.presentation.features.common.ui.LoadingComposable
import sebag.florent.presentation.features.home.ui.ArtListComposable

@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
    onNavigationRequested: (String) -> Unit
) {
    when (state) {
        is HomeState.Loading -> {
            LoadingComposable()
        }
        is HomeState.Success -> {
            ArtListComposable(state.artList, onAction, onNavigationRequested)
        }
        is HomeState.Error -> {
            ErrorComposable {
                onAction(HomeAction.Retry)
            }
        }
    }
}
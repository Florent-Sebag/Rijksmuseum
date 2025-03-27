package sebag.florent.presentation.features.details

import androidx.compose.runtime.Composable
import sebag.florent.presentation.features.commonui.ErrorComposable
import sebag.florent.presentation.features.commonui.LoadingComposable
import sebag.florent.presentation.features.details.ui.ArtDetailsComposable

@Composable
fun DetailsScreen(
    state: DetailsState,
    onAction: (DetailsAction) -> Unit,
    onNavigationRequested: (String) -> Unit
) {
    when (state) {
        is DetailsState.Loading -> {
            LoadingComposable()
        }
        is DetailsState.Success -> {
            ArtDetailsComposable(state.art)
        }
        is DetailsState.Error -> {
            ErrorComposable {
                onAction(DetailsAction.Retry)
            }
        }
    }
}
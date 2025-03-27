package sebag.florent.presentation.features.details

import androidx.compose.runtime.Composable
import sebag.florent.presentation.features.commonui.LoadingComposable

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
            ArtComposable()
        }
        is DetailsState.Error -> {
            // Show error message
        }
    }
}

@Composable
fun ArtComposable() {

}
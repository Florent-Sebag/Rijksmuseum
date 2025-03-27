package sebag.florent.presentation.features.details.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import sebag.florent.presentation.features.common.model.ArtUiModel

@Composable
fun ArtDetailsComposable(artDetails: ArtUiModel) {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item { ArtImageComposable(artDetails.imageUrl) }
            item { ArtDetailsContentComposable(artDetails) }
        }
    }
}


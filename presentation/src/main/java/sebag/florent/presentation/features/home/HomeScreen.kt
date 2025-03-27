package sebag.florent.presentation.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sebag.florent.presentation.features.home.ui.ArtListComposable

@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit
) {
    when (state) {
        is HomeState.Loading -> {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("HOLA MUNDO")
                }
            }
        }
        is HomeState.Success -> {
            ArtListComposable(state.artList)
        }
        is HomeState.Error -> {
            // Show error message
        }
    }
}
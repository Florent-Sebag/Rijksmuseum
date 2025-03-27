package sebag.florent.presentation.host.ui

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import sebag.florent.presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComposable() {
    CenterAlignedTopAppBar(
        modifier = Modifier.wrapContentHeight(),
        title = {
            Text(
                stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold
            )
        }
    )
}
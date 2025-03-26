package sebag.florent.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import sebag.florent.presentation.navigation.NavGraph
import sebag.florent.presentation.theme.MuseumTheme

class HostActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MuseumTheme {
                NavGraph()
            }
        }
    }
}
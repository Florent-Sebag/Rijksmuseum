package sebag.florent.presentation.host

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import sebag.florent.presentation.features.home.HomeScreen
import sebag.florent.presentation.features.home.HomeViewModel
import sebag.florent.presentation.host.ui.TopBarComposable

@Composable
fun HostScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = { TopBarComposable() },
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(navController = navController, startDestination = Screen.Home.route) {
                composable(Screen.Home.route) {
                    HomeRoute()
                }
            }
        }
    }
}

@Composable
fun HomeRoute() {
    val homeViewModel: HomeViewModel = koinViewModel()
    val state by homeViewModel.state.collectAsState()
    HomeScreen(
        state = state,
        onAction = homeViewModel::onAction
    )
}
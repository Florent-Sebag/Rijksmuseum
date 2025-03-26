package sebag.florent.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel
import sebag.florent.presentation.features.home.HomeScreen
import sebag.florent.presentation.features.home.HomeViewModel

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = koinViewModel()
            val state by homeViewModel.state.collectAsState()
            HomeScreen(
                state = state,
                onAction = homeViewModel::onAction
            )
        }
    }
}
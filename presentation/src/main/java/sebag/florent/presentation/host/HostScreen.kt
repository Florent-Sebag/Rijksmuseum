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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.koin.androidx.compose.koinViewModel
import sebag.florent.presentation.features.details.DetailsScreen
import sebag.florent.presentation.features.details.DetailsViewModel
import sebag.florent.presentation.features.home.HomeScreen
import sebag.florent.presentation.features.home.HomeViewModel
import sebag.florent.presentation.host.ui.TopBarComposable
import sebag.florent.presentation.navigation.NavigationRoute
import sebag.florent.presentation.navigation.Navigator

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
            NavGraph(navController = navController)
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    val navigator = Navigator(navController)

    NavHost(navController = navController, startDestination = NavigationRoute.Home.route) {
        composable(NavigationRoute.Home.route) {
            HomeRoute(navigator)
        }
        composable(
            route = NavigationRoute.Details.route,
            arguments = listOf(navArgument("itemId") { type = NavType.StringType })
        ) {
            DetailsRoute(navigator)
        }
    }
}

@Composable
fun HomeRoute(navigator: Navigator) {
    val homeViewModel = koinViewModel<HomeViewModel>()
    val state by homeViewModel.state.collectAsState()
    HomeScreen(
        state = state,
        onAction = homeViewModel::onAction,
        onNavigationRequested = navigator::navigateTo
    )
}

@Composable
fun DetailsRoute(navigator: Navigator) {
    val detailsViewModel = koinViewModel<DetailsViewModel>()
    val state by detailsViewModel.state.collectAsState()

    DetailsScreen(
        state = state,
        onAction = detailsViewModel::onAction,
        onNavigationRequested = navigator::navigateTo
    )
}
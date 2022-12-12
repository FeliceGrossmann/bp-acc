package codes.felice.bonprix.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import codes.felice.bonprix.models.BonViewModel
import codes.felice.bonprix.ui.screen.CategoryScreen
import codes.felice.bonprix.ui.screen.OverviewScreen
import codes.felice.bonprix.ui.screen.WebViewScreen

@Composable
fun NavigationController(viewModel: BonViewModel) {

    val navController = rememberNavController()
    viewModel.navController = navController

    NavHost(navController = navController, startDestination = Screen.Overview.route) {

        composable(route = Screen.Overview.route) {
            OverviewScreen(viewModel = viewModel)
        }

        composable(route = Screen.Category.route) {
            CategoryScreen(viewModel = viewModel)
        }

        composable(route = Screen.WebView.route) {
            WebViewScreen(viewModel = viewModel)
        }

    }


}
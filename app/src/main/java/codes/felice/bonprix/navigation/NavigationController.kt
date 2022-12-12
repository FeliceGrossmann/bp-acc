package codes.felice.bonprix.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import codes.felice.bonprix.models.BonViewModel
import codes.felice.bonprix.ui.screen.CategoryScreen
import codes.felice.bonprix.ui.screen.OverviewScreen
import codes.felice.bonprix.ui.screen.WebViewScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Composable
fun NavigationController(viewModel: BonViewModel) {

    val navController = rememberAnimatedNavController()
    viewModel.navController = navController

    BackHandler(enabled = true) {
        viewModel.categories.removeLast()
        viewModel.title.value = viewModel.categories.lastOrNull()?.label ?: "bonprix"
        navController.popBackStack()
    }

    AnimatedNavHost(navController = navController, startDestination = Screen.Overview.route) {

        composable(
            route = Screen.Overview.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentScope.SlideDirection.Start,
                    animationSpec = tween(700)
                )
            }
        ) {
            OverviewScreen(viewModel = viewModel)
        }

        composable(
            route = Screen.Category.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentScope.SlideDirection.Start,
                    animationSpec = tween(700)
                )
            }
        ) {
            CategoryScreen(viewModel = viewModel)
        }

        composable(
            route = Screen.WebView.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentScope.SlideDirection.Start,
                    animationSpec = tween(700)
                )
            }
        ) {
            WebViewScreen(viewModel = viewModel)
        }

    }


}
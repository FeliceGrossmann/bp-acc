package codes.felice.bonprix.navigation

sealed class Screen(val route: String) {

    object Overview : Screen("screen_overview")
    object Category : Screen("screen_category")
    object WebView : Screen("screen_webview")

}

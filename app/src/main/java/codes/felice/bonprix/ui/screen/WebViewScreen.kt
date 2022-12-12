package codes.felice.bonprix.ui.screen

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import codes.felice.bonprix.models.BonViewModel

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(viewModel: BonViewModel) {

    AndroidView(
        factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                loadUrl(viewModel.url)
            }
        },
        update = {
            it.loadUrl(viewModel.url)
        }
    )

}
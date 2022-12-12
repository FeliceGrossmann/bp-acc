package codes.felice.bonprix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import codes.felice.bonprix.models.BonViewModel
import codes.felice.bonprix.navigation.NavigationController
import codes.felice.bonprix.ui.theme.AndroidCodeChellangeBonprixTheme

class MainActivity : ComponentActivity() {

    private val viewModel: BonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCodeChellangeBonprixTheme {
                NavigationController(viewModel = viewModel)
            }
        }
    }
}
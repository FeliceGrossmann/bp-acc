package codes.felice.bonprix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codes.felice.bonprix.models.BonViewModel
import codes.felice.bonprix.navigation.NavigationController
import codes.felice.bonprix.ui.theme.AndroidCodeChellangeBonprixTheme

class MainActivity : ComponentActivity() {

    private val viewModel: BonViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var title by remember { mutableStateOf("bonprix") }

            AndroidCodeChellangeBonprixTheme {
                Column(
                    modifier = Modifier
                        .padding(
                            top = 6.dp,
                            start = 12.dp
                        )
                ) {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 36.sp,
                            fontFamily = FontFamily(
                                Font(R.font.javatext)
                            )
                        )
                    )
                }
                Column(
                    modifier = Modifier.padding(top = 80.dp)
                ) {
                    NavigationController(viewModel = viewModel)
                }

                viewModel.updateNavigation()

                viewModel._title.observe(this) {
                    title = it
                }

            }
        }
    }
}
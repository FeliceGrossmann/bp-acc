package codes.felice.bonprix.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codes.felice.bonprix.R
import codes.felice.bonprix.models.BonViewModel
import codes.felice.bonprix.models.Category
import codes.felice.bonprix.navigation.Screen
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun CategoryListItem(category: Category, viewModel: BonViewModel) {
    category.image?.let { img ->
        Button(
            onClick = {
                viewModel.categories.add(category)
                viewModel.title.value = viewModel.categories.lastOrNull()?.label ?: viewModel.navController.context.getString(R.string.label)
                viewModel.url = viewModel.categories.lastOrNull()?.url ?: viewModel.navController.context.getString(R.string.base_url)
                category.children?.let {
                    viewModel.image = img
                    viewModel.navController.navigate(Screen.Category.route)
                    return@Button
                }

                viewModel.navController.navigate(Screen.WebView.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            shape = RectangleShape,
            contentPadding = PaddingValues(0.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(img)
                            .apply(
                                block = fun ImageRequest.Builder.() {
                                    placeholder(R.drawable.img)
                                }
                            )
                            .build(),
                    ),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = "${category.label} Image"
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 12.dp)
                        .align(Alignment.BottomEnd),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Text(
                        text = category.label,
                        style = TextStyle(
                            color = Color.White,
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(1f, 1f)
                            ),
                            fontSize = 36.sp
                        )
                    )
                }

            }

        }
    }
}
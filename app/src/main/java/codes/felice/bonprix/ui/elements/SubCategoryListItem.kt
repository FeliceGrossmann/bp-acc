package codes.felice.bonprix.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codes.felice.bonprix.R
import codes.felice.bonprix.models.BonViewModel
import codes.felice.bonprix.models.Category
import codes.felice.bonprix.navigation.Screen

@Composable
fun SubCategoryListItem(category: Category, viewModel: BonViewModel) {

    Button(
        onClick = {
            viewModel.categories.add(category)
            viewModel.title.value = viewModel.categories.last().label
            viewModel.url = viewModel.categories.lastOrNull()?.url ?: viewModel.navController.context.getString(R.string.base_url)
            category.children?.let {
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
        contentPadding = PaddingValues(8.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
                    .align(Alignment.CenterStart),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = category.label,
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 16.sp
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .align(Alignment.CenterEnd),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.round_arrow_forward_ios_24
                    ),
                    contentDescription = "Forward Icon"
                )
            }
        }
    }

}
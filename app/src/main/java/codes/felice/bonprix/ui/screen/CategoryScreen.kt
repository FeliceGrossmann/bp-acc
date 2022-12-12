package codes.felice.bonprix.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import codes.felice.bonprix.R
import codes.felice.bonprix.models.BonViewModel
import codes.felice.bonprix.models.Category
import codes.felice.bonprix.ui.elements.SubCategoryListItem
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun CategoryScreen(viewModel: BonViewModel) {
    val category: Category? by remember { mutableStateOf(viewModel.categories.last()) }

    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(viewModel.image)
                .apply(
                    block = fun ImageRequest.Builder.() {
                        placeholder(R.drawable.img)
                    }
                )
                .build(),
        ),
        contentScale = ContentScale.FillWidth,
        contentDescription = "${category?.label} Image"
    )

    category?.children?.let { subs ->
        Box(
            modifier = Modifier.padding(top = 108.dp)
        ) {
            LazyColumn {
                items(
                    items = subs,
                    itemContent = {
                        SubCategoryListItem(
                            category = it,
                            viewModel = viewModel
                        )
                    }
                )
            }
        }
    }

}
package codes.felice.bonprix.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import codes.felice.bonprix.models.BonViewModel
import codes.felice.bonprix.ui.elements.CategoryListItem

@Composable
fun OverviewScreen(viewModel: BonViewModel) {

    LazyColumn {
        items(
            items = viewModel.categoryListResponse,
            itemContent = {
                CategoryListItem(category = it, viewModel = viewModel)
            }
        )
    }

}
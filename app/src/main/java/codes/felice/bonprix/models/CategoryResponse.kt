package codes.felice.bonprix.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse (
    @SerialName("categories")
    val categories: List<Category>
)
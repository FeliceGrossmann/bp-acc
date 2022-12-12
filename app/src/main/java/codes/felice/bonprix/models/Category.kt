package codes.felice.bonprix.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category (
    @SerialName("label")
    val label: String,
    @SerialName("url")
    val url: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("children")
    val children: List<Category>? = null
)
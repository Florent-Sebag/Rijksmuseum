package sebag.florent.presentation.features.common.model

data class ArtUiModel(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val artist: String,
    val description: String?
)
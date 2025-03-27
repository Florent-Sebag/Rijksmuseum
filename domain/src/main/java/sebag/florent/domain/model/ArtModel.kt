package sebag.florent.domain.model

data class ArtModel(
    val id: String,
    val title: String,
    val imageUrl: String?,
    val artist: String,
    val description: String?
)
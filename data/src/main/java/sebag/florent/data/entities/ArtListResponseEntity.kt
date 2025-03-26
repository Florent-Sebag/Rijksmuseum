package sebag.florent.data.entities

data class ArtListResponseEntity(
    val artObjects: List<ArtObjectResponseEntity>
)

data class ArtObjectResponseEntity(
    val id: String,
    val title: String
)
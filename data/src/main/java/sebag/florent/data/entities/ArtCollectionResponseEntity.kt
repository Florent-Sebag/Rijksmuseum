package sebag.florent.data.entities

data class ArtCollectionResponseEntity(
    val artObjects: List<ArtObjectResponseEntity>
)

data class ArtObjectResponseEntity(
    val id: String,
    val title: String
)
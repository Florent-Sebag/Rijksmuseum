package sebag.florent.data.repositories.mapper

import sebag.florent.data.entities.ArtDetailResponseEntity
import sebag.florent.data.entities.ArtListResponseEntity
import sebag.florent.data.entities.ArtObjectResponseEntity
import sebag.florent.domain.model.ArtModel

class ArtRepositoryMapperImpl : ArtRepositoryMapper {

    override fun toModel(entity: ArtObjectResponseEntity) = ArtModel(
        id = entity.id,
        title = entity.title,
        imageUrl = entity.webImage?.url,
        artist = entity.artist ?: "Unknown Artist",
        description = null
    )

    override fun toModel(entity: ArtListResponseEntity) : List<ArtModel> =
        entity.artObjects.map { artObject ->
            toModel(artObject)
        }

    override fun toModel(entity: ArtDetailResponseEntity) = ArtModel(
        id = entity.artObject.id,
        title = entity.artObject.title,
        imageUrl = entity.artObject.webImage?.url,
        artist = entity.artObject.artist ?: "Unknown Artist",
        description = entity.artObject.description
    )
}
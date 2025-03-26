package sebag.florent.data.repositories.mapper

import sebag.florent.data.entities.ArtListResponseEntity
import sebag.florent.data.entities.ArtObjectResponseEntity
import sebag.florent.domain.model.ArtModel

class ArtRepositoryMapperImpl : ArtRepositoryMapper {

    override fun toModel(entity: ArtObjectResponseEntity) = ArtModel(
        id = entity.id,
        title = entity.title,
        //imageUrl = webImage?.url ?: ""
    )

    override fun toModel(entity: ArtListResponseEntity) : List<ArtModel> =
        entity.artObjects.map { artObject ->
            toModel(artObject)
        }
}
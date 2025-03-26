package sebag.florent.data.repositories.mapper

import sebag.florent.data.entities.ArtListResponseEntity
import sebag.florent.data.entities.ArtObjectResponseEntity
import sebag.florent.domain.model.ArtModel

interface ArtRepositoryMapper {

    fun toModel(entity: ArtObjectResponseEntity): ArtModel

    fun toModel(entity: ArtListResponseEntity) : List<ArtModel>
}
package sebag.florent.data.mock

import sebag.florent.data.entities.ArtListResponseEntity
import sebag.florent.data.entities.ArtObjectResponseEntity
import sebag.florent.domain.model.ArtModel

object DataMockProvider {
    val artObjectResponseEntityMock = ArtObjectResponseEntity("1", "El pollo loco")

    val artListResponseEntityMock = ArtListResponseEntity(
        listOf(
            artObjectResponseEntityMock
        )
    )

    val artMock = ArtModel("1", "El pollo loco")

    val artListMock = listOf(
        artMock
    )
}
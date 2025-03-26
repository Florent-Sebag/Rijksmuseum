package sebag.florent.domain.mock

import sebag.florent.domain.model.ArtModel

object DomainMockProvider {

    val artMock = ArtModel("1", "El pollo loco")

    val artListMock = listOf(
        artMock
    )
}
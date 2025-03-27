package sebag.florent.presentation.features.common.utils

import sebag.florent.domain.model.ArtModel
import sebag.florent.presentation.features.common.model.ArtUiModel

fun ArtModel.toUiArtModel() = ArtUiModel(
    id = this.id,
    title = this.title,
    imageUrl = this.imageUrl,
    artist = this.artist,
    description = this.description
)
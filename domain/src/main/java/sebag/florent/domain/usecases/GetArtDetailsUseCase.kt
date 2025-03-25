package sebag.florent.domain.usecases

import sebag.florent.domain.model.ArtModel

interface GetArtDetailsUseCase {

    suspend operator fun invoke(artId: String): Result<ArtModel>
}
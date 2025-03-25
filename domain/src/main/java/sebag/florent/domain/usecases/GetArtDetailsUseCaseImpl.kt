package sebag.florent.domain.usecases

import sebag.florent.domain.model.ArtModel
import sebag.florent.domain.repositories.ArtRepository

class GetArtDetailsUseCaseImpl(
    private val artRepository: ArtRepository
) : GetArtDetailsUseCase {

    override suspend fun invoke(artId: String): Result<ArtModel> =
        artRepository.getArtDetails(artId)
}
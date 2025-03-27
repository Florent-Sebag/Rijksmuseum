package sebag.florent.domain.usecases

import sebag.florent.domain.model.ArtModel
import sebag.florent.domain.repositories.ArtRepository

class GetArtListUseCaseImpl(
    private val artRepository: ArtRepository
) : GetArtListUseCase {

    override suspend fun invoke(page: Int, limit: Int): Result<List<ArtModel>> =
        artRepository.getArtList(page, limit)
}
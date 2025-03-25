package sebag.florent.domain.usecases

import sebag.florent.domain.model.ArtModel

interface GetArtListUseCase {

    suspend operator fun invoke(page: Int, limit: Int): Result<List<ArtModel>>
}
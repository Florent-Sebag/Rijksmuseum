package sebag.florent.domain.repositories

import sebag.florent.domain.model.ArtModel

interface ArtRepository {

    suspend fun getArtCollection(): Result<List<ArtModel>>

    suspend fun getArtDetails(artId: String): Result<ArtModel>
}
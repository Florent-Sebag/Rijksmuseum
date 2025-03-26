package sebag.florent.domain.repositories

import sebag.florent.domain.model.ArtModel

interface ArtRepository {

    suspend fun getArtList(): Result<List<ArtModel>>

    suspend fun getArtDetails(artId: String): Result<ArtModel>
}
package sebag.florent.data.repositories

import sebag.florent.data.repositories.mapper.ArtRepositoryMapper
import sebag.florent.data.service.ArtApiService
import sebag.florent.domain.model.ArtModel
import sebag.florent.domain.repositories.ArtRepository

class ArtRepositoryImpl(
    private val apiService: ArtApiService,
    private val mapper: ArtRepositoryMapper
) : ArtRepository {

    override suspend fun getArtList(page: Int, limit: Int): Result<List<ArtModel>> {

        return try {
            val response = apiService.getArtList(page, limit)
            Result.success(mapper.toModel(response))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getArtDetails(artId: String): Result<ArtModel> {

        return try {
            val response = apiService.getArtDetails(artId)
            Result.success(mapper.toModel(response))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
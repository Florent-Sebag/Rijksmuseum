package sebag.florent.data.source.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sebag.florent.data.entities.ArtDetailResponseEntity
import sebag.florent.data.entities.ArtListResponseEntity
import sebag.florent.data.entities.ArtObjectResponseEntity

interface ArtApiService {

    @GET("collection")
    suspend fun getArtList(
        @Query("p") page: Int,
        @Query("ps") pageSize: Int
    ): ArtListResponseEntity

    @GET("collection/{objectNumber}")
    suspend fun getArtDetails(
        @Path("objectNumber") id: String
    ): ArtDetailResponseEntity
}
package sebag.florent.data.source.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sebag.florent.data.entities.ArtCollectionResponseEntity
import sebag.florent.data.entities.ArtObjectResponseEntity

interface ArtApiService {

    @GET("/collection")
    suspend fun getArtCollection(
        @Query("p") page: Int,
        @Query("ps") pageSize: Int
    ): ArtCollectionResponseEntity

    @GET("/{objectNumber}")
    suspend fun getArtDetails(
        @Path("id") id: String
    ): ArtObjectResponseEntity
}
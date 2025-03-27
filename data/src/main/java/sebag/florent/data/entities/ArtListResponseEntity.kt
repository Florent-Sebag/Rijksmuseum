package sebag.florent.data.entities

import com.google.gson.annotations.SerializedName

data class ArtListResponseEntity(
    @SerializedName("artObjects") val artObjects: List<ArtObjectResponseEntity>
)

data class ArtObjectResponseEntity(
    @SerializedName("objectNumber") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("webImage") val webImage: WebImageResponseEntity?,
    @SerializedName("principalOrFirstMaker") val artist: String?,
    @SerializedName("description") val description: String?
)

data class WebImageResponseEntity(
    @SerializedName("url") val url: String
)
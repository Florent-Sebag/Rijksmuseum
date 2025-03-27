package sebag.florent.data.entities

import com.google.gson.annotations.SerializedName

data class ArtDetailResponseEntity(
    @SerializedName("artObject") val artObject: ArtObjectResponseEntity
)
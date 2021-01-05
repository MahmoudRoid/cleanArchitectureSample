package ir.mahmoudroid.core.data.network.resource

import com.google.gson.annotations.SerializedName

data class ResponseResource(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("year") val year: Int,
    @field:SerializedName("color") val color: String,
    @field:SerializedName("pantone_value") val pantone_value: String
)
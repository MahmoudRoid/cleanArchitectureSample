package ir.mahmoudroid.core.domain

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @field:SerializedName("page") val page: Int,
    @field:SerializedName("per_page") val per_page: Int,
    @field:SerializedName("total") val total: Int,
    @field:SerializedName("total_pages") val total_pages: Int,
    @field:SerializedName("data") val data: T,
    @field:SerializedName("support") val support: Support

)


data class ErrorResponse(
    @field:SerializedName("page") val page: Int,
    @field:SerializedName("per_page") val per_page: Int,
    @field:SerializedName("total") val total: Int,
    @field:SerializedName("total_pages") val total_pages: Int,
    @field:SerializedName("data") val data: List<Any>,
    @field:SerializedName("support") val support: Support
)



data class Support(
    @field:SerializedName("url") val url: String,
    @field:SerializedName("text") val text: String
)
package ir.mahmoudroid.core.domain

import com.google.gson.annotations.SerializedName

data class Resource(
    val id: Int,
    val name: String,
    val year: Int,
    val color: String,
    val pantone_value: String
)
package ir.mahmoudroid.core.domain

import com.google.gson.annotations.SerializedName

data class Student(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
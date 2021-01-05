package ir.mahmoudroid.core.domain

data class User(
    val id: Int? = null,
    val name: String,
    val age: Int,
    val isStaff: Boolean = false
)
package ir.mahmoudroid.core.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_tbl")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String,
    val age: Int,
    val isStaff: Boolean = false
)

@Entity(tableName = "country_tbl")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String
)
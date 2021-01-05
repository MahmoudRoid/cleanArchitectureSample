package ir.mahmoudroid.core.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao{

    @Insert
    fun insert(userEntity: UserEntity)

    @Query("select * from user_tbl")
    suspend fun getAll(): List<UserEntity>

    @Query("select * from user_tbl")
    fun getAllAsync(): LiveData<List<UserEntity>>

    @Query("select isStaff from user_tbl where user_tbl.name = :name")
    fun isStaff(name: String): Boolean

    @Delete
    fun deleteUser(user: UserEntity)


}
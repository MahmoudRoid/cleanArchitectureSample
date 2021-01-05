package ir.mahmoudroid.core.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryDao {

    @Insert
    fun insert(countryEntity: CountryEntity)

    @Query("select * from country_tbl")
    fun getAll(): List<CountryEntity>

    @Query("select * from country_tbl")
    fun getAllAsync(): LiveData<List<CountryEntity>>

}
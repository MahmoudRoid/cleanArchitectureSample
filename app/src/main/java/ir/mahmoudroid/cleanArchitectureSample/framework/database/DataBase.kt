package ir.mahmoudroid.cleanArchitectureSample.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.mahmoudroid.core.data.database.CountryDao
import ir.mahmoudroid.core.data.database.CountryEntity
import ir.mahmoudroid.core.data.database.UserDao
import ir.mahmoudroid.core.data.database.UserEntity

const val DATABASE_NAME = "TestRoomDB"

@Database(entities = arrayOf(UserEntity::class, CountryEntity::class), version = 2)
abstract class DataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun countryDao(): CountryDao

    companion object {
        @Volatile private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase? {
            if (INSTANCE == null) {
                synchronized(DataBase::class) {
                    INSTANCE = Room
                        .databaseBuilder(context, DataBase::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
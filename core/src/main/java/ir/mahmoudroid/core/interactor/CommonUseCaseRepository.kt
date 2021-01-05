package ir.mahmoudroid.core.interactor

import androidx.lifecycle.LiveData
import ir.mahmoudroid.core.domain.User

interface CommonUseCaseRepository {

    fun insertItemToUserDB(user: User)
    suspend fun getAllUserItemsFromDB(): List<User>
    fun getAllUserItemsFromDBAsync(): LiveData<List<User>>
    fun deleteUser(user: User)

}
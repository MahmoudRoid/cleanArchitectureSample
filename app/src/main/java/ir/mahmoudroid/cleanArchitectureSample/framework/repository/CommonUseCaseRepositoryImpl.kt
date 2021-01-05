package ir.mahmoudroid.cleanArchitectureSample.framework.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import ir.mahmoudroid.core.data.database.UserDao
import ir.mahmoudroid.core.domain.User
import ir.mahmoudroid.core.ext.toUserEntity
import ir.mahmoudroid.core.ext.toUserList
import ir.mahmoudroid.core.interactor.CommonUseCaseRepository

class CommonUseCaseRepositoryImpl(
    private val userDao: UserDao
): CommonUseCaseRepository {


    override fun insertItemToUserDB(user: User) {
        userDao.insert(user.toUserEntity())
    }

    override suspend fun getAllUserItemsFromDB(): List<User> {
        return userDao.getAll().toUserList()
    }

    override fun getAllUserItemsFromDBAsync(): LiveData<List<User>> {
//        method 1
/*        return MutableLiveData(userDao.getAllAsync().value.orEmpty().map { item ->
            User(
                item.id,
                item.name,
                item.age,
                item.isStaff)
        })*/

        // method 2
        return Transformations.map(userDao.getAllAsync()) { list ->
            val newList: ArrayList<User> = ArrayList()
            list?.forEach {
                val temp = User(
                    it.id,
                    it.name,
                    it.age,
                    it.isStaff)
                newList.add(temp)
            }
            return@map newList
        }



        //return userDao.getAllAsync()
    }

    override fun deleteUser(user: User) {
        userDao.deleteUser(user.toUserEntity())
    }

}
package ir.mahmoudroid.cleanArchitectureSample.ui.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.mahmoudroid.core.domain.User
import ir.mahmoudroid.core.interactor.BaseUseCaseRepository
import ir.mahmoudroid.core.interactor.CommonUseCaseRepository
import ir.mahmoudroid.core.util.CustomToolbar
import ir.mahmoudroid.core.util.ToolbarButtonType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DatabaseViewModel(
    private val baseUseCaseRepository: BaseUseCaseRepository,
    private val commonUseCaseRepository: CommonUseCaseRepository
): ViewModel() {

    val textLiveData = MutableLiveData<String>()
    var userList = mutableListOf<User>()

    fun setToolbar() {
        baseUseCaseRepository.setToolbar(
            CustomToolbar(
                "Database",
                ToolbarButtonType.menu,
                ToolbarButtonType.back
            )
        )
    }

    fun addUser() {
        viewModelScope.launch(Dispatchers.Main) {
            val randomId = (1..500000).random()
            val sampleUser = User(
                name = "ali _ $randomId",
                age = (1..120).random(),
                isStaff = false
            )

            withContext(Dispatchers.IO){
                commonUseCaseRepository.insertItemToUserDB(sampleUser)
            }
            textLiveData.value = "Added new item ($randomId )"
        }
    }

    fun getAllUsers() {

        viewModelScope.launch(Dispatchers.Main) {

            userList = commonUseCaseRepository.getAllUserItemsFromDB() as MutableList<User>

            if(userList.isNotEmpty()){
                textLiveData.value =
                    """
                | yyy   
                | ALL numbers = ${userList.size}
                | id = ${userList[userList.size-1].id}
                | name = ${userList[userList.size-1].name}
                | age = ${userList[userList.size-1].age}
                | isStaff = ${userList[userList.size-1].isStaff}
            """.trimMargin()
            }
            else
                textLiveData.value = "No data"

        }

    }

    fun getAllUsersWithLiveData(): LiveData<List<User>> {
        return commonUseCaseRepository.getAllUserItemsFromDBAsync()
    }

    fun deleteFirstUser() {
        viewModelScope.launch(Dispatchers.IO) {
            commonUseCaseRepository.deleteUser(userList[0])
            userList.remove(userList[0])
        }
    }


}
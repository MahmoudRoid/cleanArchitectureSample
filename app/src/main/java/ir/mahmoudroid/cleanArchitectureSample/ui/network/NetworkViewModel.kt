package ir.mahmoudroid.cleanArchitectureSample.ui.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haroldadmin.cnradapter.NetworkResponse
import ir.mahmoudroid.core.data.network.student.StudentRepository
import ir.mahmoudroid.core.domain.Student
import ir.mahmoudroid.core.ext.toStudentList
import ir.mahmoudroid.core.interactor.BaseUseCaseRepository
import ir.mahmoudroid.core.util.CustomToolbar
import ir.mahmoudroid.core.util.Snack
import ir.mahmoudroid.core.util.ToolbarButtonType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NetworkViewModel(
    private val baseUseCaseRepository: BaseUseCaseRepository,
    private val studentRepository: StudentRepository
): ViewModel() {

    val listLiveData  = MutableLiveData<List<Student>>()
    var list = mutableListOf<Student>()
    private var pageNumber = 1


    fun setToolbar() {
        baseUseCaseRepository.setToolbar(
            CustomToolbar(
                "Network",
                ToolbarButtonType.menu,
                ToolbarButtonType.back
            )
        )
    }


    fun getData() {

        var error: Boolean? = null

        viewModelScope.launch {
            // show progress
            baseUseCaseRepository.setProgressBar(true) // handle it in main activity observedata

            withContext(Dispatchers.IO){
                when(val result = studentRepository.getStudentsList(pageNumber)){
                    is NetworkResponse.Success -> {
                        list.addAll(result.body.data.toStudentList())
                    }
                    is NetworkResponse.ServerError -> {
                        error = true
                    }
                    is NetworkResponse.NetworkError -> {
                        error = true
                    }
                    is NetworkResponse.UnknownError -> {
                        error = true
                    }
                }
            }
            // end show progress
            baseUseCaseRepository.setProgressBar(false)

            error?.let {
                // show error
                baseUseCaseRepository.alertUser(Snack("error occurred"))
            } ?: kotlin.run {
                // show list
                //baseUseCaseRepository.alertUser(Snack("count is = ${list?.size?.toString() ?: "-1"}"))
                if(list.isNotEmpty())
                    listLiveData.value = list
                // add pageNumber
                pageNumber++
            }

        }
    }

    fun onItemClicked(item: Student) {
        baseUseCaseRepository.alertUser(Snack(item.first_name))
    }


}
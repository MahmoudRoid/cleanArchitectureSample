package ir.mahmoudroid.core.data.network.student

import com.haroldadmin.cnradapter.NetworkResponse
import ir.mahmoudroid.core.domain.BaseResponse
import ir.mahmoudroid.core.domain.ErrorResponse
import ir.mahmoudroid.core.domain.Student

interface StudentRepository {

    suspend fun getStudentsList(pageNumber: Int): NetworkResponse<BaseResponse<List<ResponseStudent>>, ErrorResponse>

}
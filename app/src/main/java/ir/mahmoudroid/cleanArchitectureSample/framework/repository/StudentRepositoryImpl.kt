package ir.mahmoudroid.cleanArchitectureSample.framework.repository

import com.haroldadmin.cnradapter.NetworkResponse
import ir.mahmoudroid.core.data.network.api.StudentApi
import ir.mahmoudroid.core.data.network.student.ResponseStudent
import ir.mahmoudroid.core.data.network.student.StudentRepository
import ir.mahmoudroid.core.domain.BaseResponse
import ir.mahmoudroid.core.domain.ErrorResponse

class StudentRepositoryImpl(
    private val studentApi: StudentApi
): StudentRepository {


    override suspend fun getStudentsList(pageNumber: Int): NetworkResponse<BaseResponse<List<ResponseStudent>>, ErrorResponse> {
        return studentApi.getStudents(pageNumber)
    }

}
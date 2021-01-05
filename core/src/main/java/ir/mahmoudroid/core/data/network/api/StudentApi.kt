package ir.mahmoudroid.core.data.network.api

import com.haroldadmin.cnradapter.NetworkResponse
import ir.mahmoudroid.core.data.network.student.ResponseStudent
import ir.mahmoudroid.core.domain.BaseResponse
import ir.mahmoudroid.core.domain.ErrorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StudentApi {

    @GET("users")
    suspend fun getStudents(
        @Query("page") page: Int
    ): NetworkResponse<BaseResponse<List<ResponseStudent>>, ErrorResponse>

}
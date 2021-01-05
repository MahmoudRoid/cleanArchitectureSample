package ir.mahmoudroid.core.data.network.api

import com.haroldadmin.cnradapter.NetworkResponse
import ir.mahmoudroid.core.data.network.resource.ResponseResource
import ir.mahmoudroid.core.domain.BaseResponse
import ir.mahmoudroid.core.domain.ErrorResponse
import retrofit2.http.GET

interface ResourceApi {

    @GET("unknown")
    suspend fun getSliders(): NetworkResponse<BaseResponse<List<ResponseResource>>, ErrorResponse>

}
package ir.mahmoudroid.cleanArchitectureSample.di

import ir.mahmoudroid.core.data.network.api.ResourceApi
import ir.mahmoudroid.core.data.network.api.StudentApi
import org.koin.dsl.module
import retrofit2.Retrofit


val webServiceModule = module{

    single<StudentApi>{
        get<Retrofit>().create(StudentApi::class.java)
    }

    single<ResourceApi>{
        get<Retrofit>().create(ResourceApi::class.java)
    }

}
package ir.mahmoudroid.cleanArchitectureSample.di

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import ir.mahmoudroid.core.data.network.student.StudentRepository
import ir.mahmoudroid.core.interactor.BaseUseCaseRepository
import ir.mahmoudroid.core.interactor.CommonUseCaseRepository
import ir.mahmoudroid.cleanArchitectureSample.framework.repository.BaseUseCaseRepositoryImpl
import ir.mahmoudroid.cleanArchitectureSample.framework.repository.CommonUseCaseRepositoryImpl
import ir.mahmoudroid.cleanArchitectureSample.framework.repository.StudentRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val SHARED_NAME = "cleanArchitectureSample_shared"

val repositoryModule = module {

    single<SharedPreferences>{
        androidContext().getSharedPreferences(SHARED_NAME,MODE_PRIVATE)
    }

    single<BaseUseCaseRepository>{
        BaseUseCaseRepositoryImpl()
    }

    single<CommonUseCaseRepository> {
        CommonUseCaseRepositoryImpl(get())
    }

    single<StudentRepository> {
        StudentRepositoryImpl(get())
    }

}

package ir.mahmoudroid.cleanArchitectureSample.di

import ir.mahmoudroid.cleanArchitectureSample.base.App
import org.koin.dsl.module

val databaseModule = module {

    single{
       App.database.userDao()
    }

    single{
        App.database.countryDao()
    }

}
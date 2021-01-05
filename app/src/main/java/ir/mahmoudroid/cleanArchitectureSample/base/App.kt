package ir.mahmoudroid.cleanArchitectureSample.base

import android.app.Application
import ir.mahmoudroid.cleanArchitectureSample.di.*
import ir.mahmoudroid.cleanArchitectureSample.framework.database.DataBase
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {

    companion object {
        lateinit var database: DataBase
    }

    override fun onCreate() {
        super.onCreate()

        // config database
        database = DataBase.getInstance(this)!!

        // DI
        startKoin {
            androidContext(this@App) // used to paa context to DI
            modules(
                listOf(
                    networkModule,
                    databaseModule,
                    viewModelModule,
                    webServiceModule,
                    repositoryModule
                )
            )
        }

    }

}
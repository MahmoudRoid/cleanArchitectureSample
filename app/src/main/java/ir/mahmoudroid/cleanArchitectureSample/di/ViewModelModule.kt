package ir.mahmoudroid.cleanArchitectureSample.di

import ir.mahmoudroid.cleanArchitectureSample.ui.db.DatabaseViewModel
import ir.mahmoudroid.cleanArchitectureSample.ui.home.HomeViewModel
import ir.mahmoudroid.cleanArchitectureSample.ui.main.MainViewModel
import ir.mahmoudroid.cleanArchitectureSample.ui.network.NetworkViewModel
import ir.mahmoudroid.cleanArchitectureSample.ui.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel { MainViewModel(get()) }
    viewModel { SplashViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { DatabaseViewModel(get(),get()) }
    viewModel { NetworkViewModel(get(),get()) }

}
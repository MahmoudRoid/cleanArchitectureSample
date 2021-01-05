package ir.mahmoudroid.cleanArchitectureSample.ui.main

import androidx.lifecycle.ViewModel
import ir.mahmoudroid.core.interactor.BaseUseCaseRepository

class MainViewModel(
        private val baseUseCaseRepository: BaseUseCaseRepository
)
    : ViewModel() {

    fun provideNavigateUser() = baseUseCaseRepository.provideNavigation()
    fun provideToolbar() = baseUseCaseRepository.provideToolbar()
    fun provideAlertUser() = baseUseCaseRepository.provideAlertUser()

}
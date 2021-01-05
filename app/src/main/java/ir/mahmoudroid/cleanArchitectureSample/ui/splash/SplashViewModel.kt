package ir.mahmoudroid.cleanArchitectureSample.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.mahmoudroid.core.interactor.BaseUseCaseRepository
import ir.mahmoudroid.core.util.NavPage
import ir.mahmoudroid.cleanArchitectureSample.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(
        private val baseUseCaseRepository: BaseUseCaseRepository
): ViewModel() {

    fun initial(){
        viewModelScope.launch {
            delay(2000)
            baseUseCaseRepository.navigateUser(NavPage.Navigate(R.id.action_splashFragment_to_homeFragment))

        }
    }

}
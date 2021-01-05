package ir.mahmoudroid.cleanArchitectureSample.ui.home

import androidx.lifecycle.ViewModel
import ir.mahmoudroid.core.interactor.BaseUseCaseRepository
import ir.mahmoudroid.core.util.*
import ir.mahmoudroid.cleanArchitectureSample.R

class HomeViewModel(
        private val baseUseCaseRepository: BaseUseCaseRepository
): ViewModel() {

    fun setToolbar() {
        baseUseCaseRepository.setToolbar(CustomToolbar(
                "Home",
                ToolbarButtonType.menu,
                ToolbarButtonType.back
        ))
    }

    fun goDatabaseFragment() {
        baseUseCaseRepository.navigateUser(NavPage.Navigate(
            R.id.action_homeFragment_to_databaseFragment
        ))
    }

    fun goNetworkFragment() {
        baseUseCaseRepository.navigateUser(NavPage.Navigate(
            R.id.action_homeFragment_to_networkFragment
        ))
    }


}
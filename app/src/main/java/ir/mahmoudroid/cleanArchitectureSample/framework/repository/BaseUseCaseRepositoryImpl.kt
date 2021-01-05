package ir.mahmoudroid.cleanArchitectureSample.framework.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.mahmoudroid.core.interactor.BaseUseCaseRepository
import ir.mahmoudroid.core.util.CustomToolbar
import ir.mahmoudroid.core.util.NavPage
import ir.mahmoudroid.core.util.UiAlert

class BaseUseCaseRepositoryImpl : BaseUseCaseRepository {

    val navPageLiveData = MutableLiveData<NavPage>()
    val toolbarLiveData = MutableLiveData<CustomToolbar>()
    val uiAlertLiveData = MutableLiveData<UiAlert>()
    val progressBarLiveData = MutableLiveData<Boolean>()



    override fun navigateUser(navPage: NavPage) {
        navPageLiveData.value = navPage
    }
    override fun provideNavigation(): LiveData<NavPage> = navPageLiveData

    override fun setToolbar(toolbar: CustomToolbar) {
       toolbarLiveData.value = toolbar
    }
    override fun provideToolbar(): LiveData<CustomToolbar> = toolbarLiveData

    override fun alertUser(uiAlert: UiAlert) {
        uiAlertLiveData.value = uiAlert
    }
    override fun provideAlertUser(): LiveData<UiAlert> = uiAlertLiveData

    override fun setProgressBar(stattus: Boolean) {
        progressBarLiveData.value = stattus
    }
    override fun provideProgressBar(): LiveData<Boolean> = progressBarLiveData


}
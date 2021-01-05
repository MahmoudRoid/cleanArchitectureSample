package ir.mahmoudroid.core.interactor

import android.os.Bundle
import androidx.lifecycle.LiveData
import ir.mahmoudroid.core.util.CustomToolbar
import ir.mahmoudroid.core.util.NavPage
import ir.mahmoudroid.core.util.UiAlert

interface BaseUseCaseRepository {

    fun navigateUser(navPage: NavPage)
    fun provideNavigation(): LiveData<NavPage>

    fun setToolbar(toolbar: CustomToolbar)
    fun provideToolbar(): LiveData<CustomToolbar>

    fun alertUser(uiAlert: UiAlert)
    fun provideAlertUser(): LiveData<UiAlert>

    fun setProgressBar(stattus: Boolean)
    fun provideProgressBar(): LiveData<Boolean>
}
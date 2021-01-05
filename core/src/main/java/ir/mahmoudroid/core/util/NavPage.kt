package ir.mahmoudroid.core.util

import android.os.Bundle

sealed class NavPage {

    data class Navigate(
        val destination: Int,
        val bundle: Bundle? = null
    ): NavPage()

   class PopBack(): NavPage()

}
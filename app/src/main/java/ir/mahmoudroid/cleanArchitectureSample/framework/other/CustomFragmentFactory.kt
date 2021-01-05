package ir.mahmoudroid.cleanArchitectureSample.framework.other

import androidx.fragment.app.FragmentFactory
import ir.mahmoudroid.cleanArchitectureSample.ui.home.HomeFragment
import ir.mahmoudroid.cleanArchitectureSample.ui.splash.SplashFragment

class CustomFragmentFactory(

) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =


        when (className) {

            SplashFragment::class.java.name -> {
                SplashFragment()
            }

            HomeFragment::class.java.name -> {
                HomeFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}
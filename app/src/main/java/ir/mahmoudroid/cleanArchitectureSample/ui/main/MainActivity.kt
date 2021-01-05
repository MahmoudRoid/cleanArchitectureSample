package ir.mahmoudroid.cleanArchitectureSample.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import ir.mahmoudroid.core.util.*
import ir.mahmoudroid.cleanArchitectureSample.R
import ir.mahmoudroid.cleanArchitectureSample.framework.other.CustomFragmentFactory
import ir.mahmoudroid.cleanArchitectureSample.ui.dialog.DialogDescription
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by inject()
    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }
    var currentFragment: Int? = 0
    var drawerGravity = Gravity.START



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = CustomFragmentFactory()
        setContentView(R.layout.activity_main)

        initNavigation()

        observes()

        toolbarInit()
    }

    private fun initNavigation() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            currentFragment = destination.id
            txtToolbar.text = destination.label

            when(currentFragment){
                R.id.splashFragment -> {
                    toolbar.visibility = View.GONE
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
                R.id.homeFragment -> {
                    // change mainActivity theme to avoid showing logo in screen

                    drawerLayout.setBackgroundColor(resources.getColor(R.color.backgrounds))
                    toolbar.visibility = View.VISIBLE
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
            }

        }
    }

    private fun toolbarInit() {

        ivBack.setOnClickListener {
            onBackPressed()
        }

        ivMenu.setOnClickListener {
            drawerLayout.openDrawer(drawerGravity)
        }

    }


    private fun observes() {

        // navigation
        viewModel.provideNavigateUser().observe(this, Observer {
            it.let {
                when (it) {
                    is NavPage.Navigate -> {
                        navController.navigate(it.destination, it.bundle)
                    }
                    is NavPage.PopBack -> {
                        onBackPressed()
                    }
                }
            }
        })

        // toolabr
        viewModel.provideToolbar().observe(this, Observer {
            txtToolbar.text = it.title
            when (it.rightBtn) {
                ToolbarButtonType.empty -> {
                    ivMenu.visibility = View.INVISIBLE
                }
                ToolbarButtonType.menu -> {
                    ivMenu.visibility = View.VISIBLE
                    ivMenu.setImageResource(R.drawable.ic_berger_menu_light)
                }
            }
            when (it.leftBtn) {
                ToolbarButtonType.empty -> {
                    ivBack.visibility = View.INVISIBLE
                }
                ToolbarButtonType.back -> {
                    ivMenu.visibility = View.VISIBLE
                    ivBack.setImageResource(R.drawable.ic_arrow_left)
                }
            }
            // click
            it.callback?.let { callback ->
                ivMenu.setOnClickListener {
                    callback.invoke()
                }
            } ?: run {
                ivMenu.setOnClickListener {
                    drawerLayout.openDrawer(drawerGravity)
                }
            }
        })

        // alert
        viewModel.provideAlertUser().observe(this, Observer {
            when (it) {
                is Toast -> {
                    android.widget.Toast.makeText(this, it.text, android.widget.Toast.LENGTH_SHORT).show()
                }
                is Snack -> {
                    Snackbar.make(root, it.text, Snackbar.LENGTH_LONG).show()

                }
                is Dialog -> {
                    DialogDescription(
                            this,
                            it.bodyText,
                            it.callback).show()
                }
            }
        })

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(drawerGravity)) {
            drawerLayout.closeDrawer(drawerGravity)
        }
        else{
            when(currentFragment){
                R.id.splashFragment -> {
                }
                R.id.homeFragment -> {
                    navController.popBackStack()
                    finish()
                    exitProcess(0)
                }
                else -> {navController.popBackStack()}
            }
        }
    }
}
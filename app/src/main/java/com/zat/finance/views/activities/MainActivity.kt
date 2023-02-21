package com.zat.finance.views.activities

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigationItem
import com.tenclouds.fluidbottomnavigation.listener.OnTabSelectedListener
import com.zat.finance.R
import com.zat.finance.base.BaseActivity
import com.zat.finance.utils.gone
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_drawer_menu.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(
            this,
            R.id.mainFragment)
        profileInformation.singleClick {
            replaceMainFragment(R.id.profileFragment)
            sideDrawer.closeDrawer(GravityCompat.START)
        }
        contactSupport.singleClick {
            replaceMainFragment(R.id.contactSupportFragment)
            sideDrawer.closeDrawer(GravityCompat.START)
        }
        terms.singleClick {
            replaceMainFragment(R.id.termsAndCondFragment)
            sideDrawer.closeDrawer(GravityCompat.START)
        }
        privacyPolicymenu.singleClick {
            replaceMainFragment(R.id.privacyPolicyFragment)
            sideDrawer.closeDrawer(GravityCompat.START)
        }



        fluidBottomNavigation.accentColor = ContextCompat.getColor(this, R.color.statu_bar)
        fluidBottomNavigation.backColor = ContextCompat.getColor(this, R.color.white)
        fluidBottomNavigation.textColor = ContextCompat.getColor(this, R.color.color_back_to_signin)
        fluidBottomNavigation.iconColor = ContextCompat.getColor(this, R.color.black)
        fluidBottomNavigation.iconSelectedColor = ContextCompat.getColor(this, R.color.white)
        fluidBottomNavigation.items =
            listOf(
                FluidBottomNavigationItem(
                    getString(R.string.home),
                    ContextCompat.getDrawable(this, R.drawable.home)),
                FluidBottomNavigationItem(
                    getString(R.string.news),
                    ContextCompat.getDrawable(this, R.drawable.news)),
                FluidBottomNavigationItem(
                    getString(R.string.group),
                    ContextCompat.getDrawable(this, R.drawable.group)),
                FluidBottomNavigationItem(
                    getString(R.string.profile),
                    ContextCompat.getDrawable(this, R.drawable.profile)),
            )
        fluidBottomNavigation.onTabSelectedListener = object : OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                when (position) {
                    0 -> {
                        replaceMainFragment(R.id.homeFragment)
                    }
                    1 -> {
                        replaceMainFragment(R.id.feedFragment)
                    }
                    2 -> {
                        replaceMainFragment(R.id.groupFragment)
                    }
                    3 -> {
                        replaceMainFragment(R.id.profileFragment)
                    }
                }
            }
        }

        sideDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id== R.id.homeFragment ||
                    destination.id == R.id.feedFragment ||
                destination.id == R.id.groupFragment ||
                destination.id == R.id.profileFragment){
                fluidBottomNavigation.visible()
            }
            else{
                fluidBottomNavigation.gone()
            }
    }

}
    fun toggleDrawer() {
        if (sideDrawer.isDrawerOpen(GravityCompat.START)) {
            sideDrawer.closeDrawer(GravityCompat.START)

        } else {
            sideDrawer.openDrawer(GravityCompat.START)
        }
    }
    override fun attachViewMode() {
    }
}
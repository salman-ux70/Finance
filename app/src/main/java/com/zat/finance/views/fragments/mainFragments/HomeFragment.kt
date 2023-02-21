package com.zat.finance.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.CATEGORY_NAME
import com.zat.finance.utils.dummyList
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.activities.MainActivity
import com.zat.finance.views.adapters.HomeAdapter
import kotlinx.android.synthetic.main.fragment_group.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.btn_bell
import kotlinx.android.synthetic.main.fragment_home.notification


class HomeFragment : BaseFragment<BaseViewModel>() {
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var drawerLayout: DrawerLayout
    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_drawer_home.singleClick {
            (currentActivity() as MainActivity).toggleDrawer()

        }
        btnViewAll.singleClick {
            currentActivity().replaceMainFragment(R.id.action_homeFragment_to_transactionsFragment)
        }
        sendTv.singleClick {
         currentActivity().replaceMainFragment(R.id.action_homeFragment_to_transferFragment)
        }
        recieveTv.singleClick {
            currentActivity().replaceMainFragment(R.id.action_homeFragment_to_requestFragment2)
        }
        btn_bell.singleClick {
            notification.isActivated = !notification.isActivated
            currentActivity().replaceMainFragment(R.id.action_homeFragment_to_notificationFragment)
        }
        homeAdapter = HomeAdapter(currentActivity()){
        }
        homeAdapter.updateData(dummyList)
      //  recycler_home.isNestedScrollingEnabled = false
        recycler_home.let {
            it.adapter = homeAdapter
        }


    }

}
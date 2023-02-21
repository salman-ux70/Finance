package com.zat.finance.views.fragments.mainFragments

import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.android.synthetic.main.fragment_group.*
import kotlinx.android.synthetic.main.fragment_group.btn_bell
import kotlinx.android.synthetic.main.fragment_group.notification
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BaseFragment<BaseViewModel>() {
    private lateinit var drawerLayout: DrawerLayout

    override val layoutId: Int
        get() = R.layout.fragment_profile
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_bell.singleClick {
            notification.isActivated = !notification.isActivated
            currentActivity().replaceMainFragment(R.id.action_profileFragment_to_notificationFragment)
        }
        Privacy_policy_tv.singleClick {
            currentActivity().replaceMainFragment(R.id.action_profileFragment_to_privacyPolicyFragment)
        }
        btn_drawer_profile.singleClick {
            (currentActivity() as MainActivity).toggleDrawer()
        }
        Change_Password.singleClick {
          currentActivity().replaceMainFragment(R.id.action_profileFragment_to_createNewPasswordFragment2)
        }
        account_info_tv.singleClick {
            currentActivity().replaceMainFragment(R.id.action_profileFragment_to_accountInfoFragment)
        }
        Manage_Payment_tv.singleClick {
            currentActivity().replaceMainFragment(R.id.action_profileFragment_to_managePaymentFragment)
        }
    }

}
package com.zat.finance.views.fragments.authFragments

import android.content.Intent
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_choose_subscription.*


class ChooseSubscriptionFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_choose_subscription
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
     chechBox.singleClick {
         chechBox.isActivated = !chechBox.isActivated
     }
     checkBoxYearly.singleClick {
         checkBoxYearly.isActivated = !checkBoxYearly.isActivated
     }
     chechBoxweekly.singleClick {
         chechBoxweekly.isActivated = !chechBoxweekly.isActivated
     }
        btn_drawer.singleClick {
            currentActivity().replaceFragmentInAuth(R.id.setUpProfileFragment)
        }
     btnSave.singleClick {
         val intent = Intent(activity,MainActivity::class.java)
         startActivity(intent)
     }
    }


}
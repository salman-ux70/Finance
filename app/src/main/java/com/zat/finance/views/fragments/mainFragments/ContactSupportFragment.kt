package com.zat.finance.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_contact_support.*


class ContactSupportFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_contact_support
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
     btn_drawer_contact_support.singleClick {
         currentActivity().replaceMainFragment(R.id.homeFragment)
     }
    }

}
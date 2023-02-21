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
import kotlinx.android.synthetic.main.fragment_add_new_account.*
import kotlinx.android.synthetic.main.fragment_manage_payment.*


class AddNewAccountFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_add_new_account
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        addCadrbackImage.singleClick {
            currentActivity().replaceMainFragment(R.id.managePaymentFragment)
        }
//        btn_drawer.singleClick {
//            currentActivity().replaceMainFragment(R.id.managePaymentFragment)
//        }
    }

}
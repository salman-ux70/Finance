package com.zat.finance.views.fragments.mainFragments

import androidx.fragment.app.Fragment
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_manage_payment.*
import kotlinx.android.synthetic.main.fragment_scan_card.*


class ScanCardFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_scan_card
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_drawer_scan.singleClick {
            currentActivity().replaceMainFragment(R.id.profileFragment)
        }
    }

}
package com.zat.finance.views.fragments.mainFragments

import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_request.*
import kotlinx.android.synthetic.main.fragment_transfer.*


class TransferFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_transfer
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {

        btn_drawer_tranfer.singleClick {
            currentActivity().replaceMainFragment(R.id.homeFragment)
        }

    }

}
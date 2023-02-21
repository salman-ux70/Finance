package com.zat.finance.views.fragments.mainFragments

import android.view.View
import androidx.fragment.app.Fragment
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_manage_payment.*

class ManagePaymentFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_manage_payment
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        paymentbackImage.singleClick {
            currentActivity().replaceMainFragment(R.id.profileFragment)
        }
        three_dots.singleClick {
            popup_menu_payment.visibility = if (popup_menu_payment.visibility == View.GONE )View.VISIBLE else View.GONE
        }
        backbutton_img.singleClick {
            currentActivity().replaceMainFragment(R.id.profileFragment)
        }
        AddnewTV.singleClick {
         currentActivity().replaceMainFragment(R.id.action_managePaymentFragment_to_addNewAccountFragment)
        }
        scan_image.singleClick {
            currentActivity().replaceMainFragment(R.id.action_managePaymentFragment_to_scanCardFragment)
        }
    }


}
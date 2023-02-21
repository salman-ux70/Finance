package com.zat.finance.views.fragments.authFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_reset_password.*


class ResetPasswordFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_reset_password
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        tvBackToSignIn.singleClick {
            currentActivity().replaceFragmentInAuth(R.id.action_resetPasswordFragment_to_loginFragment)
        }
        btnSubmit.singleClick {
            currentActivity().replaceFragmentInAuth(R.id.action_resetPasswordFragment_to_OTPVerificationFragment)
        }

    }

}
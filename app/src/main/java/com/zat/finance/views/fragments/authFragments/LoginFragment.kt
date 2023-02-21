package com.zat.finance.views.fragments.authFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*

class LoginFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_login
    override val viewModelClass: Class<BaseViewModel>
        get() =  BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
     tvResetPassword.singleClick {
         currentActivity().replaceFragmentInAuth(R.id.action_loginFragment_to_resetPasswordFragment)
     }
     btnLogin.singleClick {
        // currentActivity().replaceFragmentInAuth(R.id.action_loginFragment_to_setUpProfileFragment)
         val intent = Intent(activity, MainActivity::class.java)
         startActivity(intent)
     }
     tvSignUp.singleClick {
         currentActivity().replaceFragmentInAuth(R.id.action_loginFragment_to_registerFragment)
     }
        chechBox.singleClick {
            chechBox.isActivated = !chechBox.isActivated
        }
    }


}
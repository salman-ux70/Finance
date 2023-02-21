package com.zat.finance.views.fragments.authFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.databinding.FragmentRegisterBinding
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_register
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java


    override fun observeLiveData() {

    }

    override fun init() {
      /*  chechBox.singleClick {
            showToast("ausdfh")
        }*/
         tvLogin.singleClick {
           currentActivity().replaceFragmentInAuth(R.id.action_registerFragment_to_loginFragment)
       }
        btnCreateAccount.singleClick {
            currentActivity().replaceFragmentInAuth(R.id.action_registerFragment_to_setUpProfileFragment2)
        }

    }

}



package com.zat.finance.views.fragments.authFragments

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.activities.AuthActivity
import com.zat.finance.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_create_new_password.*

class CreateNewPasswordFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_create_new_password
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        if (activity is  MainActivity){
            tvBackToSignIn.visibility = View.GONE
        }
     btnSave.singleClick {
         when(activity){
             is AuthActivity -> currentActivity().replaceFragmentInAuth(R.id.action_createNewPasswordFragment_to_setUpProfileFragment)
             else ->           currentActivity().replaceMainFragment(R.id.action_createNewPasswordFragment2_to_profileFragment)
         }
     }
     tvBackToSignIn.singleClick {
         currentActivity().replaceFragmentInAuth(R.id.action_createNewPasswordFragment_to_loginFragment)
     }
    }

}
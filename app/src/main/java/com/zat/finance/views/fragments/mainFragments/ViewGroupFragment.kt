package com.zat.finance.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_group.*
import kotlinx.android.synthetic.main.fragment_view_group.*
import kotlinx.android.synthetic.main.fragment_view_group.btn_bell


class ViewGroupFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_view_group
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_drawer_group_member.singleClick {
            currentActivity().replaceMainFragment(R.id.groupFragment)
        }
        linearbg.singleClick {
         currentActivity().replaceMainFragment(R.id.action_viewGroupFragment_to_groupMemberFragment)
        }

            val constraintLayout = requireView().findViewById<ConstraintLayout>(R.id.popup_menu_view_view)
           btn_bell.singleClick {
                constraintLayout.visibility = if (constraintLayout.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            }
        editGroup_tv.singleClick {
         currentActivity().replaceMainFragment(R.id.action_viewGroupFragment_to_editGroupFragment)
        }
        InviteGroup_tv.singleClick {
         currentActivity().replaceMainFragment(R.id.action_viewGroupFragment_to_inviteGroupFragment)
        }

        }


}
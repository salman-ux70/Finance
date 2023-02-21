package com.zat.finance.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.dummyList
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.adapters.InviteGroupAdapter
import kotlinx.android.synthetic.main.fragment_invite_group.*


class InviteGroupFragment : BaseFragment<BaseViewModel>() {
    private lateinit var inviteGroupAdapter : InviteGroupAdapter
    override val layoutId: Int
        get() = R.layout.fragment_invite_group
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_drawer_view_group.singleClick {
            currentActivity().replaceMainFragment(R.id.viewGroupFragment)
        }
        inviteGroupAdapter = InviteGroupAdapter(currentActivity()){}
        inviteGroupAdapter.updateData(dummyList)
        Invite_RecyclerView.let {
            it.adapter = inviteGroupAdapter
        }

    }

}
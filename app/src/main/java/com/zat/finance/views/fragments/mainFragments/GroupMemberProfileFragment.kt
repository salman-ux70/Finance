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
import com.zat.finance.views.adapters.MemberProfileAdapter
import kotlinx.android.synthetic.main.fragment_group_member_profile.*

class GroupMemberProfileFragment : BaseFragment<BaseViewModel>() {
    private lateinit var memberProfileAdapter:MemberProfileAdapter
    override val layoutId: Int
        get() = R.layout.fragment_group_member_profile

    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_drawer_member_profile.singleClick {
            currentActivity().replaceMainFragment(R.id.groupMemberFragment)
        }
     memberProfileAdapter = MemberProfileAdapter(currentActivity()){}
        memberProfileAdapter.updateData(dummyList)
        recyclerMemberProfiler.let {
            it.adapter = memberProfileAdapter
        }
    }

}
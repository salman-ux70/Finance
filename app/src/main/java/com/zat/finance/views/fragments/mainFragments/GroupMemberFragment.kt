package com.zat.finance.views.fragments.mainFragments

import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.dummyList
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.adapters.GroupMemberAdapter
import kotlinx.android.synthetic.main.fragment_group_member.*


class GroupMemberFragment : BaseFragment<BaseViewModel>() {
    private lateinit var groupMemberAdapter: GroupMemberAdapter
    override val layoutId: Int
        get() = R.layout.fragment_group_member
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_drawer_group_member.singleClick {
            currentActivity().replaceMainFragment(R.id.viewGroupFragment)
        }
        groupMemberAdapter = GroupMemberAdapter(currentActivity()) {
            currentActivity().replaceMainFragment(R.id.action_groupMemberFragment_to_groupMemberProfileFragment)

        }
        groupMemberAdapter.updateData(dummyList)
        groupmembersRecyclerView.let {
            it.adapter = groupMemberAdapter
        }

    }

}
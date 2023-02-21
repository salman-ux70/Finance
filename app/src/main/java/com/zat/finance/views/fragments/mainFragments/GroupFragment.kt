package com.zat.finance.views.fragments.mainFragments

import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.dummyList
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.activities.MainActivity
import com.zat.finance.views.adapters.GroupAdapter
import kotlinx.android.synthetic.main.fragment_group.*


class GroupFragment : BaseFragment<BaseViewModel>() {
    private lateinit var groupAdapter: GroupAdapter
    override val layoutId: Int
        get() = R.layout.fragment_group
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_bell.singleClick {
            notification.isActivated = !notification.isActivated
            currentActivity().replaceMainFragment(R.id.action_groupFragment_to_notificationFragment)
        }
        dots_image.singleClick {
            popup_menu.visibility =
                if (popup_menu.visibility == View.GONE) View.VISIBLE else View.GONE
        }
        createGroup_tv.singleClick {
            currentActivity().replaceMainFragment(R.id.action_groupFragment_to_createGroupFragment)
        }
        btn_drawer_group.singleClick {
            (currentActivity() as MainActivity).toggleDrawer()
        }
        groupAdapter = GroupAdapter(currentActivity()) {
            currentActivity().replaceMainFragment(R.id.action_groupFragment_to_viewGroupFragment)
        }
        groupAdapter.updateData(dummyList)
        groupRecyclerView.let {
            it.adapter = groupAdapter
        }
    }

}
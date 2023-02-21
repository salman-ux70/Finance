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
import com.zat.finance.views.adapters.CreateGroupAdapter
import kotlinx.android.synthetic.main.create_group_items.*
import kotlinx.android.synthetic.main.fragment_create_group.*


class CreateGroupFragment : BaseFragment<BaseViewModel>() {
    private lateinit var createGroupAdapter:CreateGroupAdapter
    override val layoutId: Int
        get() = R.layout.fragment_create_group
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
          recyclerViewCreateGroup.isNestedScrollingEnabled = false

        btn_drawer.singleClick {
         currentActivity().replaceMainFragment(R.id.groupFragment)
     }
     createGroupAdapter = CreateGroupAdapter(currentActivity()){
     }
     createGroupAdapter.updateData(dummyList)
     recyclerViewCreateGroup.let {
         it.adapter = createGroupAdapter
     }

    }

}
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
import com.zat.finance.views.adapters.EditGroupAdapter
import kotlinx.android.synthetic.main.fragment_edit_group.*


class EditGroupFragment : BaseFragment<BaseViewModel>() {
    private lateinit var editAdapter:EditGroupAdapter
    override val layoutId: Int
        get() = R.layout.fragment_edit_group
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_drawer_edit.singleClick {
            currentActivity().replaceMainFragment(R.id.viewGroupFragment)
        }
        editAdapter = EditGroupAdapter((currentActivity())){}
        editAdapter.updateData(dummyList)
        recyclerViewEditGroup.let {
            it.adapter = editAdapter
            it.isNestedScrollingEnabled = false
        }

    }

}
package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder

class MemberProfileAdapter(var context:Context, var onClick: () -> Unit):
    BaseAdapter<MemberProfileAdapter.MemberProfileViewHolder,String>() {
    class MemberProfileViewHolder(itemView:View) : BaseViewHolder(itemView){}

    override val layoutId: Int
        get() = R.layout.member_profile_items

    override fun setData(holder: MemberProfileViewHolder, model: String, position: Int) {

    }


}
package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder

class InviteGroupAdapter(var context:Context,var onClick : () -> Unit) : BaseAdapter<InviteGroupAdapter.InviteGroupViewHolder, String> (){
    class InviteGroupViewHolder(itemView:View):BaseViewHolder(itemView){}

    override val layoutId: Int
        get() = R.layout.invite_group_items

    override fun setData(holder: InviteGroupViewHolder, model: String, position: Int) {

    }
}
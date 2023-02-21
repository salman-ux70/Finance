package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder
import com.zat.finance.utils.singleClick
import kotlinx.android.synthetic.main.groupmembers_recyclerview_items.view.*

class GroupMemberAdapter(var context: Context, var onClick: () -> Unit):BaseAdapter<GroupMemberAdapter.GroupMemberViewHolder,String>() {
    class GroupMemberViewHolder(itemView:View):BaseViewHolder(itemView){}

    override val layoutId: Int
        get() = R.layout.groupmembers_recyclerview_items

    override fun setData(holder: GroupMemberViewHolder, model: String, position: Int) {
       var view = holder.itemView
       view.drag_item.singleClick {
           onClick()
       }
}
}
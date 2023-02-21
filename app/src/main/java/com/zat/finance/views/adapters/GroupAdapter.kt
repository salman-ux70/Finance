package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder
import com.zat.finance.utils.singleClick
import kotlinx.android.synthetic.main.group_recyclerview_items.view.*

class GroupAdapter(var context: Context, var onClick: () -> Unit) : BaseAdapter<GroupAdapter.GroupViewHolder, String>() {

    class GroupViewHolder(itemView: View) : BaseViewHolder(itemView) {


    }

    override val layoutId: Int
        get() = R.layout.group_recyclerview_items

    override fun setData(holder: GroupViewHolder, model: String, position: Int) {
        var view = holder.itemView
        view.drag_item.singleClick {
            onClick()
        }
    }


}
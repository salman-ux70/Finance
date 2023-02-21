package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder
import com.zat.finance.utils.singleClick
import kotlinx.android.synthetic.main.create_group_items.view.*
import kotlinx.android.synthetic.main.create_group_items.view.plusImage
import kotlinx.android.synthetic.main.edit_group_items.view.*

class EditGroupAdapter(var context : Context, var onClick : () -> Unit):BaseAdapter<EditGroupAdapter.EditGroupViewHolder,String>() {
    class EditGroupViewHolder(itemView:View):BaseViewHolder(itemView){}

    override val layoutId: Int
        get() = R.layout.edit_group_items

    override fun setData(holder: EditGroupViewHolder, model: String, position: Int) {
        var view = holder.itemView
        view.plusImageEdit.singleClick{
            view.plusImageEdit.isActivated = !view.plusImageEdit.isActivated
        }
    }
}
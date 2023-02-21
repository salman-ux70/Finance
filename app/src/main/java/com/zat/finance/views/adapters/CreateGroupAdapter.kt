package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder
import com.zat.finance.utils.singleClick
import kotlinx.android.synthetic.main.create_group_items.view.*

class CreateGroupAdapter(var context : Context, var onClick : () -> Unit) : BaseAdapter<CreateGroupAdapter.CreateGroupViewHolder,String>(){
    class CreateGroupViewHolder(itemView : View) : BaseViewHolder(itemView)

    override val layoutId: Int
        get() = R.layout.create_group_items

    override fun setData(holder: CreateGroupViewHolder, model: String, position: Int) {
     var view = holder.itemView
     view.plusImage.singleClick{
       view.plusImage.isActivated = !view.plusImage.isActivated
    }
}}
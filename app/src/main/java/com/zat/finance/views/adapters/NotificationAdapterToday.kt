package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder

class NotificationAdapterToday(var context:Context,var onClick:() -> Unit) : BaseAdapter<NotificationAdapterToday.NotificationViewHolderToday,String>() {
    class NotificationViewHolderToday(itemView:View):BaseViewHolder(itemView){}

    override val layoutId: Int
        get() = R.layout.notification_recycler_items

    override fun setData(holder: NotificationViewHolderToday, model: String, position: Int) {

    }
}
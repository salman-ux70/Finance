package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder

class NotificationAdapterWeekday(var context: Context, var onClick:() -> Unit):BaseAdapter<NotificationAdapterWeekday.NotificationViewHolderWeekly,String>() {
    class NotificationViewHolderWeekly(itemView:View):BaseViewHolder(itemView){}

    override val layoutId: Int
        get() = R.layout.notification_recycler_items

    override fun setData(holder: NotificationViewHolderWeekly, model: String, position: Int) {

    }
}
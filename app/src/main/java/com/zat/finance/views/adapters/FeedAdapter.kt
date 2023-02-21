package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder
import com.zat.finance.utils.singleClick
import kotlinx.android.synthetic.main.feed_recyclerview_items.*
import kotlinx.android.synthetic.main.feed_recyclerview_items.view.*

class FeedAdapter(var context: Context, var onClick: () -> Unit):
    BaseAdapter<HomeAdapter.HomeViewHolder, String>() {
    class FeedViewHolder(itemView: View) : BaseViewHolder(itemView) {

    }
    override val layoutId: Int
        get() =  R.layout.feed_recyclerview_items

    override fun setData(holder: HomeAdapter.HomeViewHolder, model: String, position: Int) {
        var view = holder.itemView
        view.likesHeart.singleClick {
            view.likesHeart.isActivated = !view.likesHeart.isActivated

        }


    }
}
package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder

class HomeAdapter(var context: Context, var onClick: () -> Unit) : BaseAdapter<HomeAdapter.HomeViewHolder, String>() {

    class HomeViewHolder(itemView: View) : BaseViewHolder(itemView) {
    }

    override val layoutId: Int
        get() = R.layout.home_recycler_items

    override fun setData(holder: HomeViewHolder, model: String, position: Int) {

    }


}
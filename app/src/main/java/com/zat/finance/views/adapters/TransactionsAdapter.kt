package com.zat.finance.views.adapters

import android.content.Context
import android.view.View
import com.zat.finance.R
import com.zat.finance.base.BaseAdapter
import com.zat.finance.base.BaseViewHolder

class TransactionsAdapter(var context:Context,var onClick: () -> Unit): BaseAdapter<TransactionsAdapter.TransactionViewHolder,String>() {
    class TransactionViewHolder(itemView:View) : BaseViewHolder(itemView){}

    override val layoutId: Int
        get() = R.layout.transactions_recycler_items

    override fun setData(holder: TransactionViewHolder, model: String, position: Int) {

    }
}
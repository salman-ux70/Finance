package com.zat.finance.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zat.finance.R
import com.zat.finance.views.adapters.*

abstract class BaseAdapter<VH : BaseViewHolder, D> : RecyclerView.Adapter<VH>() {

    abstract val layoutId: Int
    abstract fun setData(holder: VH, model: D, position: Int)

    private var list = ArrayList<D>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return when (layoutId) {
            R.layout.home_recycler_items ->
                HomeAdapter.HomeViewHolder(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId, parent, false)
                ) as VH
            R.layout.transactions_recycler_items ->
                TransactionsAdapter.TransactionViewHolder(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId,parent,false)
                ) as VH
            R.layout.group_recyclerview_items ->
                GroupAdapter.GroupViewHolder(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId,parent,false)
                ) as VH
            R.layout.groupmembers_recyclerview_items ->
                GroupMemberAdapter.GroupMemberViewHolder(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId,parent,false)
                ) as VH
            R.layout.member_profile_items ->
                MemberProfileAdapter.MemberProfileViewHolder(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId,parent,false)
                ) as VH

            R.layout.create_group_items ->
                CreateGroupAdapter.CreateGroupViewHolder(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId,parent,false)
                ) as VH
            R.layout.edit_group_items ->
                EditGroupAdapter.EditGroupViewHolder(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId,parent,false)
                ) as VH
            R.layout.invite_group_items ->
                InviteGroupAdapter.InviteGroupViewHolder(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId,parent,false)
                ) as VH
            R.layout.notification_recycler_items ->
                NotificationAdapterToday.NotificationViewHolderToday(
                    LayoutInflater.from(
                        parent.context
                    ).inflate(layoutId,parent,false)
                ) as VH


            else -> HomeAdapter.HomeViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(layoutId, parent, false)
            ) as VH
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (list.size > 0)
            setData(holder, list[position], position)
    }

    override fun getItemCount() = list.size
    fun updateData(newList: ArrayList<D>) {
        list = newList
        notifyDataSetChanged()
    }
}
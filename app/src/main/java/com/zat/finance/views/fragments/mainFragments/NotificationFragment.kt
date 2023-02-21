package com.zat.finance.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.dummyList
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.adapters.NotificationAdapterToday
import kotlinx.android.synthetic.main.fragment_notification.*


class NotificationFragment : BaseFragment<BaseViewModel>() {
    private lateinit var notificationAdapterToday:NotificationAdapterToday
    override val layoutId: Int
        get() = R.layout.fragment_notification
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        notificationAdapterToday = NotificationAdapterToday(currentActivity()){}
        notificationAdapterToday.updateData(dummyList)
        todayRecycler.let {
            it.adapter = notificationAdapterToday
        }
       /* yesterdayRecycler.let {
            it.adapter = notificationAdapterToday
        }
        weekendRecycler.let {
            it.adapter = notificationAdapterToday
        }*/

    }

}
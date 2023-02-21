package com.zat.finance.views.fragments.mainFragments

import androidx.drawerlayout.widget.DrawerLayout
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.dummyList
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.activities.MainActivity
import com.zat.finance.views.adapters.FeedAdapter
import kotlinx.android.synthetic.main.feed_recyclerview_items.*
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : BaseFragment<BaseViewModel>() {
    private lateinit var feedAdapter: FeedAdapter
    private lateinit var drawerLayout: DrawerLayout
    override val layoutId: Int
        get() = R.layout.fragment_feed
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_bell.singleClick {
            notification.isActivated = !notification.isActivated
            currentActivity().replaceMainFragment(R.id.action_feedFragment_to_notificationFragment)
        }
        btn_drawer.singleClick {
            (currentActivity() as MainActivity).toggleDrawer()
        }
    feedAdapter = FeedAdapter(currentActivity()){
    }
    feedAdapter.updateData(dummyList)

    feedRecyclerView.let {
        it.adapter = feedAdapter
    }


    }

}
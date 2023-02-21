package com.zat.finance.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.dummyList
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import com.zat.finance.views.adapters.TransactionsAdapter
import kotlinx.android.synthetic.main.fragment_transactions.*


class TransactionsFragment : BaseFragment<BaseViewModel>() {
    private lateinit var transactionAdapter : TransactionsAdapter

    override val layoutId: Int
        get() = R.layout.fragment_transactions
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {

    }

    override fun init() {
        btn_drawer_transaction.singleClick {
            currentActivity().replaceMainFragment(R.id.homeFragment)
        }
        transactionAdapter = TransactionsAdapter(currentActivity()){}
        transactionAdapter.updateData(dummyList)
        transaction.let {
            it.adapter = transactionAdapter
        }
    }

}
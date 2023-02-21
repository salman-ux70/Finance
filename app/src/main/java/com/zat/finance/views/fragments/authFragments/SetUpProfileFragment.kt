package com.zat.finance.views.fragments.authFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.zat.finance.R
import com.zat.finance.base.BaseFragment
import com.zat.finance.utils.singleClick
import com.zat.finance.utils.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_set_up_profile.*


class SetUpProfileFragment : BaseFragment<BaseViewModel>() {
    val Countries = arrayOf("Canada", "Australia", "England", "Pakistan", "India", "Others" )
    val cities = arrayOf("Toronto", "Sydney", "London", "Islamabad", "Delhi", "Others" )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val t=inflater.inflate(R.layout.fragment_set_up_profile, container, false)
        val spinner = t.findViewById<Spinner>(R.id.country_spinner)
        val citySpinner = t.findViewById<Spinner>(R.id.city_spinnerr)
        spinner?.adapter = ArrayAdapter(requireActivity().applicationContext, android.R.layout.simple_spinner_item, Countries) as SpinnerAdapter
        citySpinner?.adapter = ArrayAdapter(requireContext().applicationContext,android.R.layout.simple_spinner_item,cities) as SpinnerAdapter
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("Error")
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val type = parent?.getItemAtPosition(position).toString()
               // Toast.makeText(activity,type, Toast.LENGTH_LONG).show()
                println(type)
            }
        }
        citySpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                println("Error")
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val type = parent?.getItemAtPosition(position).toString()
              //  Toast.makeText(activity,type, Toast.LENGTH_LONG).show()
                println(type)
            }
        }

        return t
    }



    override val layoutId: Int
        get() = R.layout.fragment_set_up_profile
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {}

    override fun init() {
       btnSave.singleClick {
           currentActivity().replaceFragmentInAuth(R.id.action_setUpProfileFragment_to_chooseSubscriptionFragment)
       }
}}
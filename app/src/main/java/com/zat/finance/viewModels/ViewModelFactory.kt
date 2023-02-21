package com.zat.finance.utils.viewModels

import android.annotation.SuppressLint
import android.app.Application
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModelProvider
import com.zat.finance.utils.source.DataRepository

class ViewModelFactory(var dataRepository: DataRepository, application: Application) :
    ViewModelProvider.AndroidViewModelFactory(application) {
    private var application: Application? = null

    init {
        this.application = application
    }

//    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
//        with(modelClass) {
//            when {
//                isAssignableFrom(AuthViewModel::class.java) ->
//                    AuthViewModel(dataRepository, application!!)
////
////                isAssignableFrom(StaticViewModel::class.java) ->
////                    StaticViewModel(dataRepository, application!!)
////
////                isAssignableFrom(FeedViewModel::class.java)->
////                FeedViewModel(dataRepository,application!!)
////
////                isAssignableFrom(ChatViewModel::class.java)->
////                    ChatViewModel(dataRepository,application!!)
//
//                else ->
//                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
//            }
//        } as T


    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            synchronized(ViewModelFactory::class.java) {
                ViewModelFactory(
                    DataRepository(
                        application.applicationContext
                    ), application
                )
                    .also { INSTANCE = it }
            }


        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}



package com.zat.finance.utils.viewModels

import android.app.Application
import com.zat.finance.utils.source.DataRepository

class AuthViewModel(var dataRepository: DataRepository, application: Application) :
    BaseViewModel(application) {

}
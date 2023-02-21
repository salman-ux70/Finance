package com.zat.finance.utils.source

import android.content.Context
import android.util.Log
import com.zat.finance.models.ResultWrapper
import retrofit2.HttpException
import java.io.IOException

class DataRepository(private var context: Context) {

    private var apiCaller = RetrofitClient(context).getService()

    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultWrapper<T> {
        try {
            return ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            return when (throwable) {
                is IOException -> {
                    Log.d("laksjdcas", throwable.toString())
                    ResultWrapper.NetworkError
                }
                is HttpException -> {
                    Log.d("laksjdcas", throwable.toString())
                    val code = throwable.code()
                    val errorResponse = throwable.toString()

                    ResultWrapper.GenericError(code, errorResponse)
                }
                else -> {
                    Log.d("laksjdcas", throwable.toString())
                    ResultWrapper.GenericError(null, throwable.message)
                }
            }

        }
    }
}
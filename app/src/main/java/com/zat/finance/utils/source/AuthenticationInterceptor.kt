package com.zat.finance.utils.source

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthenticationInterceptor(authToken : String?,context: Context) : Interceptor {
    private var authToken : String? = null
    private var context : Context? = null
    init {
        this.authToken = authToken
        this.context = context
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalReuquest : Request = chain.request()
        val requestBuilder = originalReuquest.newBuilder()
            .addHeader("Accept","application/json")
            .method(originalReuquest.method, originalReuquest.body)

        if(!authToken.isNullOrEmpty())
        {
            requestBuilder.addHeader("Authorization","Bearer $authToken")
        }

        return chain.proceed(requestBuilder.build())
    }
}
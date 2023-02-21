package com.zat.finance.utils.source

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient(private var context: Context) {
    private var retrofit: Retrofit? = null

    private val httpClient = OkHttpClient.Builder()

    val BASE_URL = "https://aaiyp.zat.agency/"


    init {
        initRetrofit()
    }

    private fun initRetrofit() {
        var gson = GsonBuilder()
            .setLenient()
            .create()

        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.writeTimeout(30, TimeUnit.SECONDS)


//        val authToken = getUser()?.token
//
//
//
//        val interceptor: Interceptor =
//            AuthenticationInterceptor(
//                authToken,
//                context
//            )
//        httpClient.addInterceptor(interceptor)


        var retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())

        retrofit = retrofitBuilder.build()

    }
    fun getService() = retrofit!!.create<ApiCaller>(ApiCaller::class.java)

}
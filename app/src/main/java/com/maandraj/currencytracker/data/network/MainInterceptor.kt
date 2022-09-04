package com.maandraj.currencytracker.data.network

import com.maandraj.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class MainInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("apikey", BuildConfig.API_KEY)
            .build()
        return chain.proceed(request)
    }
}
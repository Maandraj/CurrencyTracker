package com.maandraj.popular_impl.data.api

import com.maandraj.popular_impl.data.models.convert.ConvertModelRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ConvertServiceApi {
    @GET("latest")
    suspend fun getConvertCurrency(
        @Query("base") base: String,
    ): Response<ConvertModelRes>
}
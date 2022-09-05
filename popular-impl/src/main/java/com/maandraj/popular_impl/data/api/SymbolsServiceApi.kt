package com.maandraj.popular_impl.data.api

import com.maandraj.popular_impl.data.models.symbols.SymbolsModelRes
import retrofit2.Response
import retrofit2.http.GET

interface SymbolsServiceApi {
    @GET("symbols")
    suspend fun getSymbols(): Response<SymbolsModelRes>
}
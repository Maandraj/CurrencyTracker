package com.maandraj.popular_impl.di

import com.maandraj.popular_impl.data.api.ConvertServiceApi
import com.maandraj.popular_impl.data.api.SymbolsServiceApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule {

    @PopularScope
    @Provides
    fun provideConvertService(retrofit: Retrofit) : ConvertServiceApi = retrofit.create(ConvertServiceApi::class.java)

    @PopularScope
    @Provides
    fun provideSymbolsService(retrofit: Retrofit) : SymbolsServiceApi = retrofit.create(SymbolsServiceApi::class.java)
}
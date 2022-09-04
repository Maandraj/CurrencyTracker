package com.maandraj.popular_impl.di

import com.maandraj.models.data.dao.ConvertDao
import com.maandraj.popular_impl.data.api.ConvertServiceApi
import com.maandraj.popular_impl.data.api.SymbolsServiceApi
import com.maandraj.popular_impl.data.mappers.convert.ConvertMapper
import com.maandraj.popular_impl.data.mappers.symbols.SymbolsMapper
import com.maandraj.popular_impl.data.repository.convert.ConvertRepo
import com.maandraj.popular_impl.data.repository.convert.ConvertRepoImpl
import com.maandraj.popular_impl.data.repository.symbols.SymbolsRepo
import com.maandraj.popular_impl.data.repository.symbols.SymbolsRepoImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @PopularScope
    @Provides
    fun provideConvertCurrencyRepo(
        convertServiceApi: ConvertServiceApi,
        convertMapper: ConvertMapper,
        convertDao: ConvertDao,

        ): ConvertRepo =
        ConvertRepoImpl(convertServiceApi = convertServiceApi,
            convertMapper = convertMapper,
            convertDao = convertDao)

    @PopularScope
    @Provides
    fun provideSymbolsRepo(
        symbolsServiceApi: SymbolsServiceApi,
        symbolsMapper: SymbolsMapper,
    ): SymbolsRepo =
        SymbolsRepoImpl(
            symbolsServiceApi = symbolsServiceApi,
            symbolsMapper = symbolsMapper,
        )
}
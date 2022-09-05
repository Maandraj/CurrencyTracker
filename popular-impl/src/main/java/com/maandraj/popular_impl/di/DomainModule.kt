package com.maandraj.popular_impl.di

import com.maandraj.popular_impl.data.repository.convert.ConvertRepo
import com.maandraj.popular_impl.data.repository.symbols.SymbolsRepo
import com.maandraj.popular_impl.domain.convert.*
import com.maandraj.popular_impl.domain.symbols.SymbolsUseCase
import com.maandraj.popular_impl.domain.symbols.SymbolsUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @PopularScope
    @Provides
    fun provideConvertUseCase(
        convertRepo: ConvertRepo,
    ): ConvertUseCase =
        ConvertUseCaseImpl(convertRepo)

    @PopularScope
    @Provides
    fun provideSymbolsUseCase(
        symbolsRepo: SymbolsRepo,
    ): SymbolsUseCase = SymbolsUseCaseImpl(symbolsRepo)

    @PopularScope
    @Provides
    fun provideSaveUseCase(
        convertRepo: ConvertRepo,
    ): UnMarkFavouriteUseCase = UnMarkFavouriteUseCaseImpl(convertRepo)

    @PopularScope
    @Provides
    fun provideRemoveUseCase(
        convertRepo: ConvertRepo,
    ): MarkFavouriteUseCase = MarkFavouriteUseCaseImpl(convertRepo)
}
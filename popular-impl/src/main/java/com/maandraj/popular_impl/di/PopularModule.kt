package com.maandraj.popular_impl.di

import com.maandraj.popular_impl.domain.convert.ConvertUseCase
import com.maandraj.popular_impl.domain.convert.UnMarkFavouriteUseCase
import com.maandraj.popular_impl.domain.convert.MarkFavouriteUseCase
import com.maandraj.popular_impl.domain.symbols.SymbolsUseCase
import com.maandraj.popular_impl.ui.screens.PopularViewModel
import dagger.Module
import dagger.Provides

@Module(includes = [
    NetworkModule::class,
    DataModule::class,
    DomainModule::class])
class PopularModule {
    @PopularScope
    @Provides
    fun providePopularViewModel(
        symbolsUseCase: SymbolsUseCase,
        convertUseCase: ConvertUseCase,
        markFavouriteUseCase: MarkFavouriteUseCase,
        unMarkFavouriteUseCase: UnMarkFavouriteUseCase,
    ): PopularViewModel = PopularViewModel(
        symbolsUseCase = symbolsUseCase,
        convertUseCase = convertUseCase,
        markFavouriteUseCase = markFavouriteUseCase,
        unMarkFavouriteUseCase = unMarkFavouriteUseCase,
    )
}
package com.maandraj.currencytracker.di

import com.maandraj.popular_api.PopularFeatureApi
import com.maandraj.popular_impl.ui.navigation.PopularFeatureImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule{
    @Singleton
    @Provides
    fun providePopularFeatureApi() : PopularFeatureApi = PopularFeatureImpl()
}
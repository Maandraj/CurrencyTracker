package com.maandraj.currencytracker.di

import android.content.Context
import com.maandraj.models.data.dao.ConvertDao
import com.maandraj.popular_api.PopularFeatureApi
import com.maandraj.popular_impl.di.PopularScreenDeps
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : PopularScreenDeps {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        fun build(): AppComponent
    }

    val popularFeatureApi: PopularFeatureApi

    override val retrofit: Retrofit
    override val convertDao: ConvertDao
}
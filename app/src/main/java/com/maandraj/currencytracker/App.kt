package com.maandraj.currencytracker

import android.app.Application
import com.maandraj.currencytracker.di.AppComponent
import com.maandraj.currencytracker.di.DaggerAppComponent
import com.maandraj.popular_impl.di.PopularScreenDepsStore

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        PopularScreenDepsStore.deps = appComponent
    }
}
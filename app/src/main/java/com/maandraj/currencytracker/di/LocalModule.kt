package com.maandraj.currencytracker.di

import android.content.Context
import androidx.room.Room
import com.maandraj.currencytracker.data.local.CurrencyDatabase
import com.maandraj.models.data.dao.ConvertDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {
    @Singleton
    @Provides
    fun provideYourDatabase(
        app: Context,
    ) = Room.databaseBuilder(
        app,
        CurrencyDatabase::class.java,
        "currency_database"
    ).build()

    @Singleton
    @Provides
    fun provideConvertDao(database: CurrencyDatabase): ConvertDao = database.convertDao()
}
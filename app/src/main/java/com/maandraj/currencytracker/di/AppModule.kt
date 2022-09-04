package com.maandraj.currencytracker.di

import dagger.Module

@Module(includes = [
    NetworkModule::class,
    CoreModule::class,
    NavigationModule::class,
    LocalModule::class])
class AppModule

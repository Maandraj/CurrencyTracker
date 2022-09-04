package com.maandraj.popular_impl.di

import androidx.annotation.RestrictTo
import com.maandraj.models.data.dao.ConvertDao
import com.maandraj.popular_impl.ui.screens.PopularViewModel
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Scope
import kotlin.properties.Delegates

@PopularScope
@Component(
    modules = [PopularModule::class],
    dependencies = [PopularScreenDeps::class])
internal interface PopularComponent {
    @Component.Builder
    interface Builder {
        fun popularScreenDeps(popularScreenDeps: PopularScreenDeps): Builder

        fun build(): PopularComponent
    }

    fun getViewModel(): PopularViewModel
}

interface PopularScreenDeps {
    val retrofit: Retrofit
    val convertDao: ConvertDao
}

interface PopularScreenDepsProvider {
    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: PopularScreenDeps

    companion object : PopularScreenDepsProvider by PopularScreenDepsStore
}

object PopularScreenDepsStore : PopularScreenDepsProvider {
    override var deps: PopularScreenDeps by Delegates.notNull()
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PopularScope
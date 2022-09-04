package com.maandraj.popular_impl.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.maandraj.core.utils.POPULAR_ROUTE
import com.maandraj.core.utils.extensions.daggerViewModel
import com.maandraj.popular_api.PopularFeatureApi
import com.maandraj.popular_impl.di.DaggerPopularComponent
import com.maandraj.popular_impl.di.PopularScreenDepsProvider
import com.maandraj.popular_impl.ui.screens.PopularScreen


class PopularFeatureImpl : PopularFeatureApi {

    override fun route(): String = POPULAR_ROUTE

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier,
    ) {
        navGraphBuilder.composable(POPULAR_ROUTE)
        {
            val deps = PopularScreenDepsProvider.deps
            val viewModel = daggerViewModel {
                DaggerPopularComponent.builder()
                    .popularScreenDeps(deps)
                    .build().getViewModel()
            }
            PopularScreen(modifier = modifier,
                viewModel = viewModel)
        }
    }
}
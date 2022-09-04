package com.maandraj.currencytracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.maandraj.feature_api.register
import com.maandraj.popular_api.PopularFeatureApi

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    popularFeatureApi: PopularFeatureApi,
) {
    NavHost(
        navController = navController,
        startDestination = popularFeatureApi.route()
    ) {
        register(
            popularFeatureApi,
            navController = navController,
            modifier = modifier
        )
    }
}
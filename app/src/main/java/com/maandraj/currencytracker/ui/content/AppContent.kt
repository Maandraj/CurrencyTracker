package com.maandraj.currencytracker.ui.content

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.maandraj.currencytracker.ui.navigation.AppNavGraph
import com.maandraj.currencytracker.ui.navigation.bottom.BottomBar
import com.maandraj.currencytracker.ui.navigation.bottom.BottomNavTub
import com.maandraj.currencytracker.ui.theme.CurrencyTrackerTheme
import com.maandraj.popular_api.PopularFeatureApi

@Composable
fun AppContent(
    popularFeatureApi: PopularFeatureApi,
) {
    CurrencyTrackerTheme() {
        val tabs = remember { BottomNavTub.values() }
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomBar(navController = navController, tabs) }
        ) { innerPaddingModifier ->
            AppNavGraph(
                navController = navController,
                modifier = Modifier.padding(innerPaddingModifier),
                popularFeatureApi = popularFeatureApi,
            )
        }
    }
}

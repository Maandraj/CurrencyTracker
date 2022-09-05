package com.maandraj.currencytracker.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.maandraj.currencytracker.App
import com.maandraj.currencytracker.ui.content.AppContent
import com.maandraj.currencytracker.ui.theme.CurrencyTrackerTheme
import com.maandraj.popular_api.PopularFeatureApi
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private val appComponent by lazy {
        (application as App).appComponent
    }

    @Inject
    lateinit var popularFeatureApi: PopularFeatureApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        popularFeatureApi = appComponent.popularFeatureApi
        setContent {
            CurrencyTrackerTheme {
                AppContent(popularFeatureApi = popularFeatureApi)
            }
        }
    }
}


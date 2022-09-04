package com.maandraj.popular_api

import com.maandraj.feature_api.FeatureApi

interface PopularFeatureApi : FeatureApi {
    fun route(): String
}
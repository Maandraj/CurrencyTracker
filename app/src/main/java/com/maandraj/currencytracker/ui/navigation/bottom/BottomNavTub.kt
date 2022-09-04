package com.maandraj.currencytracker.ui.navigation.bottom

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.maandraj.core.utils.POPULAR_ROUTE
import com.maandraj.currencytracker.R

enum class BottomNavTub(
    @StringRes val title: Int,
    @DrawableRes var icon: Int,
    val route: String,
) {
     Popular(R.string.popular_item, R.drawable.ic_popular_24, POPULAR_ROUTE)
}

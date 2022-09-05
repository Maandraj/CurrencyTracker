package com.maandraj.core.ui.viewModels

import com.maandraj.models.domain.RateModel
import com.maandraj.models.typealiases.SymbolsMap
import com.maandraj.models.utils.FilterType
import com.maandraj.models.utils.OrderType
import kotlinx.coroutines.flow.MutableStateFlow

open class CurrencyViewModel : BaseViewModel() {
    val symbols = MutableStateFlow<SymbolsMap>(mapOf())

    val rates = MutableStateFlow<List<RateModel>>(listOf())

    val filterType = MutableStateFlow<FilterType>(FilterType.ABC)

    val order = MutableStateFlow<OrderType>(OrderType.Ascending)

    val selectSymbol = MutableStateFlow("")

    val onlyFavourite = MutableStateFlow(false)
}
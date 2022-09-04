package com.maandraj.core.ui.viewModels

import com.maandraj.models.domain.RatesModel
import com.maandraj.models.typealiases.SymbolsMap
import com.maandraj.models.utils.FilterType
import com.maandraj.models.utils.OrderType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class CurrencyViewModel : BaseViewModel() {
    val symbols = MutableStateFlow<SymbolsMap>(mapOf())

    val rates = MutableStateFlow<List<RatesModel>>(listOf())

    val filterType = MutableStateFlow<FilterType>(FilterType.ABC)

    val order = MutableStateFlow<OrderType>(OrderType.Ascending)

    val selectSymbol = MutableStateFlow("")
}
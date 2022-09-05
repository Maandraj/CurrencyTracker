package com.maandraj.popular_impl.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.maandraj.core_ui.samples.CurrencyListScreen
import com.maandraj.models.domain.RateModel
import com.maandraj.models.utils.FilterType
import com.maandraj.models.utils.OrderType

@Composable
fun PopularScreen(
    modifier: Modifier,
    viewModel: PopularViewModel,
) {
    val symbols: Map<String, String> by viewModel.symbols.collectAsState()
    val rates: List<RateModel> by viewModel.rates.collectAsState()
    val filterType: FilterType by viewModel.filterType.collectAsState()
    val order: OrderType by viewModel.order.collectAsState()
    val selectSymbol: String by viewModel.selectSymbol.collectAsState()
    val isLoading: Boolean by viewModel.loading.collectAsState()
    val onlyFavourite: Boolean by viewModel.onlyFavourite.collectAsState()
    CurrencyListScreen(
        modifier = modifier,
        symbols = symbols,
        isLoading = isLoading,
        rates = rates,
        selectSymbol = selectSymbol,
        filterType = filterType,
        order = order,
        onlyFavourite = onlyFavourite,
        onClickItemIcon = { item ->
            viewModel.changeData(item)
        },
        onClickDropMenuItem = {
            viewModel.convertCurrentCurrency(it)
        },
        onRefreshing = {
            viewModel.convertCurrentCurrency(selectSymbol)
        },
        onFilterChanged = { _filter, _order ->
            viewModel.filterType.value = _filter
            viewModel.order.value = _order
        },
        onStateChange = {
            viewModel.changeState()
        }
    )
}

package com.maandraj.core_ui.samples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.maandraj.models.domain.RatesModel
import com.maandraj.models.typealiases.SymbolsMap
import com.maandraj.models.utils.FilterType
import com.maandraj.models.utils.IRateModel
import com.maandraj.models.utils.OrderType

@Composable
fun CurrencyListScreen(
    modifier: Modifier,
    isLoading: Boolean,
    symbols: SymbolsMap,
    rates: List<IRateModel>,
    selectSymbol: String,
    filterType: FilterType,
    order: OrderType,
    onClickItemIcon: (item:RatesModel) -> Unit,
    onClickDropMenuItem: (name: String) -> Unit,
    onRefreshing: () -> Unit,
    onFilterChanged: (filterType: FilterType, orderType: OrderType) -> Unit,
) {
    val swipeRefreshState = rememberSwipeRefreshState(false)
    val icon = if (order == OrderType.Ascending) Icons.Default.KeyboardArrowUp
        else Icons.Filled.KeyboardArrowDown
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            Box(Modifier
                .fillMaxWidth()
                .padding(16.dp),
                contentAlignment = Alignment.Center) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    DropDownMenuSample(
                        items = symbols.keys,
                        selectSymbol = selectSymbol) { name ->
                        onClickDropMenuItem(name)
                    }
                    DropDownMenuFilter(
                        items = FilterType.values().toSet(),
                        selectedFilterType = filterType) { item ->
                        onFilterChanged(item, order)
                    }
                    Icon(imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            val orderItem =
                                if (order == OrderType.Ascending) OrderType.Descending else OrderType.Ascending
                            onFilterChanged(filterType, orderItem)
                        })
                }
            }
        },
        content = { padding ->
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    onRefreshing()
                    swipeRefreshState.isRefreshing = true
                },
            ) {
                val itemsList = when (filterType) {
                    FilterType.ABC -> {
                        if (order == OrderType.Ascending)
                            rates.sortedBy {
                                it.name
                            }
                        else rates.sortedByDescending {
                            it.name
                        }
                    }
                    FilterType.VALUE -> {
                        if (order == OrderType.Ascending)
                            rates.sortedBy {
                                it.value
                            }
                        else rates.sortedByDescending {
                            it.value
                        }
                    }
                    else -> {
                        rates
                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .padding(padding)) {
                    itemsIndexed(itemsList) { index, item ->
                        CurrencyItem(item = item) {
                            onClickItemIcon(it as RatesModel)
                        }
                    }
                }
            }
        }
    )
    CircularProgressBarSample(isEnable = isLoading)
}
package com.maandraj.core_ui.samples

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.maandraj.core.data.models.errors.CException
import com.maandraj.core.data.models.errors.ErrorModel
import com.maandraj.core_ui.R
import com.maandraj.models.domain.RateModel
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
    error: ErrorModel?,
    filterType: FilterType,
    order: OrderType,
    onlyFavourite: Boolean,
    onClickItemIcon: (item: RateModel) -> Unit,
    onClickDropMenuItem: (name: String) -> Unit,
    onRefreshing: () -> Unit,
    onFilterChanged: (filterType: FilterType, orderType: OrderType) -> Unit,
    onStateChange: () -> Unit,
) {
    val swipeRefreshState = rememberSwipeRefreshState(false)
    val icon = if (order == OrderType.Ascending) Icons.Default.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown
    val iconFavourite = if (onlyFavourite) Icons.Default.Star
    else Icons.Filled.Home
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            Box(Modifier
                .fillMaxWidth()
                .padding(16.dp),
                contentAlignment = Alignment.Center) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Icon(imageVector = iconFavourite,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            onStateChange()
                        })
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
                                if (order == OrderType.Ascending) OrderType.Descending
                                else OrderType.Ascending
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
                when (error?.exception) {
                    is CException.NoInternetConnectionException -> {
                        Toast.makeText(LocalContext.current,
                            stringResource(R.string.error_not_internet), Toast.LENGTH_SHORT).show()
                    }
                    is CException.EmptyResponse -> {
                        Toast.makeText(LocalContext.current,
                            stringResource(R.string.error_empty), Toast.LENGTH_SHORT).show()
                    }
                    is CException.UnknownException -> {
                        Toast.makeText(LocalContext.current,
                            stringResource(R.string.error_unknown), Toast.LENGTH_SHORT).show()
                    }
                    else -> {}
                }

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
                            onClickItemIcon(it as RateModel)
                        }
                    }
                }
            }
        }
    )
    CircularProgressBarSample(isEnable = isLoading)
}
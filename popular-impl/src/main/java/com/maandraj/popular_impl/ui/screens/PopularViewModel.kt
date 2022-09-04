package com.maandraj.popular_impl.ui.screens

import androidx.lifecycle.viewModelScope
import com.maandraj.core.ui.viewModels.CurrencyViewModel
import com.maandraj.core.utils.extensions.applyIfError
import com.maandraj.core.utils.extensions.applyIfSuccess
import com.maandraj.models.domain.RatesModel
import com.maandraj.popular_impl.domain.convert.ConvertUseCase
import com.maandraj.popular_impl.domain.convert.MarkFavouriteUseCase
import com.maandraj.popular_impl.domain.convert.UnMarkFavouriteUseCase
import com.maandraj.popular_impl.domain.symbols.SymbolsUseCase
import kotlinx.coroutines.launch

class PopularViewModel(
    private val symbolsUseCase: SymbolsUseCase,
    private val convertUseCase: ConvertUseCase,
    private val markFavouriteUseCase: MarkFavouriteUseCase,
    private val unMarkFavouriteUseCase: UnMarkFavouriteUseCase,
) : CurrencyViewModel() {
    init {
        getSymbols()
    }

    private fun getSymbols() = viewModelScope.launch {
        loading.value = true
        symbolsUseCase()
            ?.applyIfSuccess {
                symbols.value = it.symbols
                it.symbols.keys.firstOrNull()
                    ?.let { value -> convertCurrentCurrency(base = value) }
            }
            ?.applyIfError { error.value = it.errorModel }
        loading.value = false
    }

    fun convertCurrentCurrency(base: String) = viewModelScope.launch {
        selectSymbol.value = base
        loading.value = true
        convertUseCase(base)
            .applyIfSuccess { rates.value = it.rates }
            .applyIfError { error.value = it.errorModel }
        loading.value = false
    }

    fun changeData(item: RatesModel) = viewModelScope.launch {
        rates.value.apply {
            val index = rates.value.indexOf(item)
            val newRate =item.copy(isFavourite = !item.isFavourite)
            if (newRate.isFavourite)
                markFavouriteUseCase.invoke(newRate)
            else
                unMarkFavouriteUseCase.invoke(newRate)
            val rates = toMutableList()
            rates[index] = newRate
            this@PopularViewModel.rates.value = rates
        }
    }
}
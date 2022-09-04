package com.maandraj.popular_impl.data.repository.symbols

import com.maandraj.core.data.models.result.ResultOf
import com.maandraj.popular_impl.domain.symbols.model.SymbolsModel

interface SymbolsRepo {
    suspend fun getSymbols(): ResultOf<SymbolsModel>
}
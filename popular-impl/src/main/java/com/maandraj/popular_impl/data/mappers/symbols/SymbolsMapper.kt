package com.maandraj.popular_impl.data.mappers.symbols

import com.maandraj.core.data.mappers.BaseMapper
import com.maandraj.popular_impl.data.models.symbols.SymbolsModelRes
import com.maandraj.popular_impl.domain.symbols.model.SymbolsModel
import javax.inject.Inject

class SymbolsMapper @Inject constructor() : BaseMapper<SymbolsModelRes, SymbolsModel> {
    override fun map(res: SymbolsModelRes) = SymbolsModel(
        symbols = res.symbolsRes,
    )
}
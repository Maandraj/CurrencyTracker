package com.maandraj.popular_impl.data.models.symbols


import com.maandraj.models.typealiases.SymbolsMap
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SymbolsModelRes(
    @Json(name = "success")
    val successRes: Boolean,
    @Json(name = "symbols")
    val symbolsRes: SymbolsMap,
)
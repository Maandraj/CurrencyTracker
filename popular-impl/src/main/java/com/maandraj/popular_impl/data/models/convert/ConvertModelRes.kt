package com.maandraj.popular_impl.data.models.convert


import com.maandraj.models.typealiases.RatesMap
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConvertModelRes(
    @Json(name = "date")
    val dateRes: String,
    @Json(name = "timestamp")
    val timeStamp: Long,
    @Json(name = "rates")
    val ratesRes: RatesMap,
    @Json(name = "success")
    val successRes: Boolean,
)
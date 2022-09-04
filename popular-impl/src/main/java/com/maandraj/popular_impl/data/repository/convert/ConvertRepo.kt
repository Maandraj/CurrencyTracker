package com.maandraj.popular_impl.data.repository.convert

import com.maandraj.core.data.models.result.ResultOf
import com.maandraj.models.domain.RatesModel
import com.maandraj.popular_impl.domain.convert.model.ConvertModel


interface ConvertRepo {
    suspend fun getConvertCurrency(
        base: String,
    ): ResultOf<ConvertModel>

    suspend fun markFavourite(item: RatesModel)

    suspend fun unMarkFavourite(item: RatesModel)
}
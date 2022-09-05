package com.maandraj.popular_impl.data.repository.convert

import com.maandraj.core.data.models.result.ResultOf
import com.maandraj.models.domain.RateModel
import com.maandraj.popular_impl.domain.convert.model.ConvertModel


interface ConvertRepo {
    suspend fun getConvertCurrency(
        base: String,
    ): ResultOf<ConvertModel>

    suspend fun markFavourite(item: RateModel)

    suspend fun unMarkFavourite(item: RateModel)
}
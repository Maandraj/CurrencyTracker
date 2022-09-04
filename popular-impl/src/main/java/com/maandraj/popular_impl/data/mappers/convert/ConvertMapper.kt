package com.maandraj.popular_impl.data.mappers.convert

import com.maandraj.core.data.mappers.BaseMapper
import com.maandraj.popular_impl.data.models.convert.ConvertModelRes
import com.maandraj.popular_impl.domain.convert.model.ConvertModel
import javax.inject.Inject

class ConvertMapper @Inject constructor(
    private val ratesMapper: RatesMapper
) : BaseMapper<ConvertModelRes, ConvertModel> {
    override fun map(res: ConvertModelRes) = ConvertModel(
        rates = ratesMapper.map(res.ratesRes),
    )
}
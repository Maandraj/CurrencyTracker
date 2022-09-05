package com.maandraj.popular_impl.data.mappers.convert

import com.maandraj.core.data.mappers.BaseMapper
import com.maandraj.models.domain.RateModel
import com.maandraj.models.typealiases.RatesMap
import javax.inject.Inject

class RatesMapper @Inject constructor(
    private val rateMapper: RateMapper,
) : BaseMapper<RatesMap, MutableList<RateModel>> {
    override fun map(res: RatesMap): MutableList<RateModel> {
        return res.map { rateMapper.map(it) }.toMutableList()
    }
}
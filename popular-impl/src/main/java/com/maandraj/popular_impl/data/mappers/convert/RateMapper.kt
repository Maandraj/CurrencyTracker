package com.maandraj.popular_impl.data.mappers.convert

import com.maandraj.core.data.mappers.BaseMapper
import com.maandraj.models.domain.RateModel
import javax.inject.Inject

class RateMapper @Inject constructor() : BaseMapper<Map.Entry<String, Double>, RateModel> {
    override fun map(res: Map.Entry<String, Double>) = RateModel(
        name = res.key, value = res.value)
}
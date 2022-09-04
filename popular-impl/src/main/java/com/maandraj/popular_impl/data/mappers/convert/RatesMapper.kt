package com.maandraj.popular_impl.data.mappers.convert

import com.maandraj.core.data.mappers.BaseMapper
import com.maandraj.models.domain.RatesModel
import com.maandraj.models.typealiases.RatesMap
import javax.inject.Inject

class RatesMapper @Inject constructor(
) : BaseMapper<RatesMap, MutableList<RatesModel>> {
    override fun map(res: RatesMap): MutableList<RatesModel> {
        val list = mutableListOf<RatesModel>()
        res.forEach { (key, value) ->
            list.add(RatesModel(name = key, value = value))
        }
        return list
    }

}
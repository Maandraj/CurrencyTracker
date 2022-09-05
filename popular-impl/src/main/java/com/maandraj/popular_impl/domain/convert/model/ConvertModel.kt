package com.maandraj.popular_impl.domain.convert.model

import androidx.room.Entity
import com.maandraj.models.domain.RateModel

data class ConvertModel(
    val rates: MutableList<RateModel>,
)
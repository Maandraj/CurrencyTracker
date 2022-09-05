package com.maandraj.models.domain

import com.maandraj.models.utils.IRateModel

data class RateModel(
    override val name: String,
    override val value: Double,
    val isFavourite: Boolean = false,
) : IRateModel

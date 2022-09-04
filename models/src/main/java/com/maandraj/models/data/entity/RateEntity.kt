package com.maandraj.models.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.maandraj.models.utils.IRateModel

@Entity
data class RateEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    override val value: Double,
    override val name: String,
) : IRateModel


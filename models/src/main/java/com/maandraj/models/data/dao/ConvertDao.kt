package com.maandraj.models.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.maandraj.models.data.entity.RateEntity

@Dao
interface ConvertDao : BaseDao<RateEntity>{
    @Query("SELECT * FROM RateEntity")
    fun getFavourites() : List<RateEntity>
}
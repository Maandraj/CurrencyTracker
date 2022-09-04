package com.maandraj.currencytracker.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import com.maandraj.models.data.dao.ConvertDao
import com.maandraj.models.data.entity.RateEntity

@Database(
    entities = [RateEntity::class],
    version = 1
)

abstract class CurrencyDatabase : RoomDatabase() {

    abstract fun convertDao(): ConvertDao
}
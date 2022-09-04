package com.maandraj.models.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = REPLACE)
    suspend fun insertAll(list: List<T>)

    @Insert(onConflict = REPLACE)
    suspend fun insert(data: T)

    @Update
    suspend fun update(data: T)

    @Delete
    suspend fun delete(data: T)
}
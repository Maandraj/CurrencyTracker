package com.maandraj.core.data.mappers

interface BaseMapper<in A, out B> {
    fun map(res: A): B
}
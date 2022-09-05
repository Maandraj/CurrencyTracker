package com.maandraj.core.data.models.result

import com.maandraj.core.data.models.errors.ErrorModel

sealed class ResultOf<out T> {
    data class Success<out R>(val data: R) : ResultOf<R>()
    data class Failure(
        val errorModel: ErrorModel?,
    ) : ResultOf<Nothing>()
}
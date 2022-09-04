package com.maandraj.core.utils.extensions

import com.maandraj.core.data.models.result.ResultOf


inline fun <reified I : Any> ResultOf<I>.applyIfSuccess(block: InHandler<I>): ResultOf<I> {
    if (this is ResultOf.Success) block(this.data)
    return this
}

inline fun <reified I : Any> ResultOf<I>.applyIfError(block: InHandler<ResultOf.Failure>): ResultOf<I> {
    if (this is ResultOf.Failure) block(this)
    return this
}
typealias InHandler<T> = (T) -> Unit



package com.maandraj.core.data.models.errors

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorModel(
    @Json(name = "code")
    val code: Int? = null,
    @Json(name = "message")
    val message: String? = null,
    val exception: CException? = null,
)

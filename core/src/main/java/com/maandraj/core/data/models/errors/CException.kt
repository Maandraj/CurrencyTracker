package com.maandraj.core.data.models.errors

sealed class CException(message : String = "") : Exception(message){
    object NoInternetConnectionException : CException()
    object UnknownException : CException()
}


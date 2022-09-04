package com.maandraj.core.utils.network

import com.maandraj.core.data.models.errors.CException
import com.maandraj.core.data.models.errors.ErrorModel
import com.maandraj.core.data.models.result.ResultOf
import retrofit2.Response
import java.util.concurrent.TimeoutException
import java.net.UnknownHostException as UnknownHostException1

//FIXME Если буду успевать обязательно прикручу к запросам,но пока конвертер жалуется на дженерики
// Предполагаю что нужен Polymorphic moshi
typealias CurrencyResponse<T> = Response<ServerResponse<T>>

data class ServerResponse<T>(
    val data: T?,
    val error: ErrorModel? = null,
)

inline fun <reified T : Any> CurrencyResponse<T>.getResult(): ResultOf<T> {
    return try {
        this.body()?.let { response ->
            response.data?.run {
                ResultOf.Success(this)
            } ?: response.error?.let {
                ResultOf.Failure(it)
            }
        } ?: ResultOf.Failure(null)
    } catch (ex: UnknownHostException1) {
        ResultOf.Failure(ErrorModel(exception = CException.NoInternetConnectionException))
    } catch (ex: TimeoutException) {
        ResultOf.Failure(ErrorModel(exception = CException.NoInternetConnectionException))
    } catch (ex: Exception) {
        ResultOf.Failure(ErrorModel(exception = CException.UnknownException))
    }
}
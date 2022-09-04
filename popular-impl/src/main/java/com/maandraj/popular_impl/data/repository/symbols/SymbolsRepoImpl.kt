package com.maandraj.popular_impl.data.repository.symbols

import com.maandraj.core.data.models.errors.CException
import com.maandraj.core.data.models.errors.ErrorModel
import com.maandraj.core.data.models.result.ResultOf
import com.maandraj.popular_impl.data.api.SymbolsServiceApi
import com.maandraj.popular_impl.data.mappers.symbols.SymbolsMapper
import com.maandraj.popular_impl.domain.symbols.model.SymbolsModel
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class SymbolsRepoImpl(
    private val symbolsServiceApi: SymbolsServiceApi,
    private val symbolsMapper: SymbolsMapper,
) : SymbolsRepo {
    override suspend fun getSymbols(): ResultOf<SymbolsModel> {
        val result = symbolsServiceApi.getSymbols()
        return try {
            result.body()?.let {
                val data = symbolsMapper.map(it)
                ResultOf.Success(data)
            } ?: ResultOf.Failure(null)

        } catch (ex: UnknownHostException) {
            ResultOf.Failure(ErrorModel(exception = CException.NoInternetConnectionException))
        } catch (ex: TimeoutException) {
            ResultOf.Failure(ErrorModel(exception = CException.NoInternetConnectionException))
        } catch (ex: Exception) {
            ResultOf.Failure(ErrorModel(exception = CException.UnknownException))
        }
    }


}
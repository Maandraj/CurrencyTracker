package com.maandraj.popular_impl.data.repository.convert

import com.maandraj.core.data.models.errors.CException
import com.maandraj.core.data.models.errors.ErrorModel
import com.maandraj.core.data.models.result.ResultOf
import com.maandraj.models.data.dao.ConvertDao
import com.maandraj.models.data.entity.RateEntity
import com.maandraj.models.domain.RateModel
import com.maandraj.popular_impl.data.api.ConvertServiceApi
import com.maandraj.popular_impl.data.mappers.convert.ConvertMapper
import com.maandraj.popular_impl.domain.convert.model.ConvertModel
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

//FIXME ИСПРАВИТЬ И СДЕЛАТЬ КАК НАДО(getResult)
class ConvertRepoImpl @Inject constructor(
    private val convertServiceApi: ConvertServiceApi,
    private val convertMapper: ConvertMapper,
    private val convertDao: ConvertDao,
) : ConvertRepo {
    override suspend fun getConvertCurrency(base: String): ResultOf<ConvertModel> {
        return try {
        val result = convertServiceApi.getConvertCurrency(base = base)
            result.body()?.let {
                val data = convertMapper.map(it)
                val favourites = convertDao.getFavourites()
                data.rates.forEachIndexed { index, rate ->
                    favourites.forEach { favourite ->
                        if (rate.name == favourite.name)
                            data.rates[index] = rate.copy(isFavourite = true)
                    }
                }
                ResultOf.Success(data)
            } ?: ResultOf.Failure(ErrorModel(exception = CException.EmptyResponse))
        } catch (ex: UnknownHostException) {
            ResultOf.Failure(ErrorModel(exception = CException.NoInternetConnectionException))
        } catch (ex: TimeoutException) {
            ResultOf.Failure(ErrorModel(exception = CException.NoInternetConnectionException))
        } catch (ex: Exception) {
            ResultOf.Failure(ErrorModel(exception = CException.UnknownException))
        }
    }

    override suspend fun markFavourite(item: RateModel) {
        convertDao.insert(RateEntity(name = item.name, value = item.value))
    }

    override suspend fun unMarkFavourite(item: RateModel) {
        convertDao.delete(RateEntity(name = item.name, value = item.value))
    }
}
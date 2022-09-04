package com.maandraj.popular_impl.domain.convert

import com.maandraj.core.domain.IUseCase
import com.maandraj.core.data.models.result.ResultOf
import com.maandraj.popular_impl.data.repository.convert.ConvertRepo
import com.maandraj.popular_impl.domain.convert.model.ConvertModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ConvertUseCaseImpl @Inject constructor(
    private val convertRepo: ConvertRepo,
) : ConvertUseCase {
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override suspend fun invoke(
        base: String,
    ): ResultOf<ConvertModel> = withContext(Dispatchers.IO){
        convertRepo.getConvertCurrency(base = base)
    }
}

interface ConvertUseCase : IUseCase.SingleInOut<String, ResultOf<ConvertModel>>

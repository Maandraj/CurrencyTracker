package com.maandraj.popular_impl.domain.convert

import com.maandraj.core.domain.IUseCase
import com.maandraj.models.domain.RateModel
import com.maandraj.popular_impl.data.repository.convert.ConvertRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class UnMarkFavouriteUseCaseImpl @Inject constructor(
    private val convertRepo: ConvertRepo,
) : UnMarkFavouriteUseCase {
    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override suspend fun invoke(
        item: RateModel,
    ) = withContext(Dispatchers.IO) {
        convertRepo.unMarkFavourite(item = item)
    }
}

interface UnMarkFavouriteUseCase : IUseCase.SingleIn<RateModel>

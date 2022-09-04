package com.maandraj.popular_impl.domain.symbols

import com.maandraj.core.domain.IUseCase
import com.maandraj.core.data.models.result.ResultOf
import com.maandraj.popular_impl.data.repository.symbols.SymbolsRepo
import com.maandraj.popular_impl.domain.symbols.model.SymbolsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SymbolsUseCaseImpl @Inject constructor(
    private val symbolsRepo: SymbolsRepo,
) : SymbolsUseCase {
    override suspend fun invoke(): ResultOf<SymbolsModel> = withContext(Dispatchers.IO)
    {
        symbolsRepo.getSymbols()
    }
}

interface SymbolsUseCase : IUseCase.Out<ResultOf<SymbolsModel>?>
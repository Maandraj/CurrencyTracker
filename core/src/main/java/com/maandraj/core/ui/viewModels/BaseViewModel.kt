package com.maandraj.core.ui.viewModels

import androidx.lifecycle.ViewModel
import com.maandraj.core.data.models.errors.ErrorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

interface IBaseViewModel {
    val error: MutableStateFlow<ErrorModel?>
    val loading: MutableStateFlow<Boolean>
}

open class BaseViewModel : ViewModel(), IBaseViewModel {
    final override val error: MutableStateFlow<ErrorModel?> = MutableStateFlow(null)
    final override val loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
}
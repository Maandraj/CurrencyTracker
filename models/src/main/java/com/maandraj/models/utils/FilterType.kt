package com.maandraj.models.utils

import androidx.annotation.StringRes
import com.maandraj.models.R

enum class FilterType(val title: String) {
    ABC(Names.ABC.title),
    VALUE(Names.VALUE.title)
}

enum class OrderType {
    Ascending, Descending
}

enum class Names( val title: String) {
    ABC("По алфавиту"), VALUE("По значению")
}

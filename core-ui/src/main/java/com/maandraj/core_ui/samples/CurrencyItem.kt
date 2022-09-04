package com.maandraj.core_ui.samples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maandraj.models.domain.RatesModel
import com.maandraj.models.utils.IRateModel

@Composable
fun CurrencyItem(
    item: IRateModel,
    onClickIcon: (item:IRateModel) -> Unit,
) {
    val (isFavourite, setFavourite) = remember {
        mutableStateOf((item as? RatesModel)?.isFavourite ?: true)
    }
    val icon = if (isFavourite) Icons.Default.Delete else Icons.Default.Star
    Row(modifier = Modifier.padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = item.name)
        Text(text = item.value.toString())
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                imageVector = icon, null, modifier = Modifier.clickable {
                    onClickIcon(item)
                    setFavourite(!isFavourite)
                })
        }
    }
}
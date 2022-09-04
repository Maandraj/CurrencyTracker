package com.maandraj.core_ui.samples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.maandraj.models.utils.FilterType

@Composable
internal fun DropDownMenuSample(
    items: Set<String>,
    selectSymbol: String,
    modifier: Modifier = Modifier,
    onClick: (name: String) -> Unit,
) {
    val expanded = remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        Row(Modifier
            .clickable { expanded.value = !expanded.value }
        ) {
            Text(text = selectSymbol)
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }) {
                items.forEach { item ->
                    DropdownMenuItem(onClick = {
                        expanded.value = false
                        onClick(item)
                    }) {
                        Text(item)
                    }
                }
            }
        }
    }
}

@Composable
internal fun DropDownMenuFilter(
    items: Set<FilterType>,
    selectedFilterType: FilterType,
    modifier: Modifier = Modifier,
    onClick: (filterType: FilterType) -> Unit,
) {
    val expanded = remember { mutableStateOf(false) }
    val name = remember { mutableStateOf(selectedFilterType.title) }
    Box(modifier = modifier) {
        Row(Modifier
            .clickable { expanded.value = !expanded.value }
        ) {
            Text(text = name.value ?: "")
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }) {
                items.forEach { item ->
                    DropdownMenuItem(onClick = {
                        expanded.value = false
                        name.value = item.title
                        onClick(item)
                    }) {
                        Text(item.title)
                    }
                }
            }
        }
    }
}
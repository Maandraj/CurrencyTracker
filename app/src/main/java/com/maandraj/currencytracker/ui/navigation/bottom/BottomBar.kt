package com.maandraj.currencytracker.ui.navigation.bottom

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import java.util.*


@Composable
fun BottomBar(navController: NavController, tabs: Array<BottomNavTub>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: BottomNavTub.Popular.route

    val routes = remember { BottomNavTub.values().map { it.route } }
    if (currentRoute in routes) {
        BottomNavigation(
            Modifier.height(56.dp)
        ) {
            tabs.forEach { tab ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(tab.icon), contentDescription = null) },
                    label = { Text(stringResource(tab.title).uppercase(Locale.getDefault())) },
                    selected = currentRoute == tab.route,
                    onClick = {
                        if (tab.route != currentRoute) {
                            navController.navigate(tab.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    alwaysShowLabel = false,
                    selectedContentColor = MaterialTheme.colors.secondary,
                    unselectedContentColor = LocalContentColor.current,
                    modifier = Modifier.navigationBarsPadding()
                )
            }
        }
    }
}
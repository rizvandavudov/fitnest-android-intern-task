package com.rizvandavudov.fitnest.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rizvandavudov.fitnest.navigation.FitNestNavHost

@Composable
fun FitNestApp(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    FitNestNavHost(
        navController = navController,
        modifier = modifier,
    )
}
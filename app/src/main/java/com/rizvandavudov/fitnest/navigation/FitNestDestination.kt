package com.rizvandavudov.fitnest.navigation

sealed interface FitNestDestination {

    val route: String

    data object Home : FitNestDestination {
        override val route: String = "home"
    }

    data object Profile : FitNestDestination {
        override val route: String = "profile"
    }
}
package com.rizvandavudov.fitnest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rizvandavudov.fitnest.feature.home.ui.HomeScreen
import com.rizvandavudov.fitnest.feature.home.ui.HomeViewModel
import com.rizvandavudov.fitnest.feature.profile.ui.ProfileScreen
import com.rizvandavudov.fitnest.feature.profile.ui.ProfileViewModel

@Composable
fun FitNestNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination =
            FitNestDestination.Home.route,
        modifier = modifier,
    ) {
        composable(
            route = FitNestDestination.Home.route,
        ) {
            val homeViewModel: HomeViewModel =
                viewModel()

            val homeUiState by
            homeViewModel
                .uiState
                .collectAsStateWithLifecycle()

            HomeScreen(
                state = homeUiState,
                onProfileClick = {
                    navController.navigate(
                        route =
                            FitNestDestination
                                .Profile
                                .route,
                    ) {
                        launchSingleTop = true
                    }
                },
                onNotificationClick = {},
                onCategoryClick = {},
                onMarketSeeAllClick = {},
                onMarketItemClick = {},
                onMarketBookmarkClick = {},
                onMarketActionClick = {},
                onGymsSeeAllClick = {},
                onGymClick = {},
                onBottomNavigationItemClick = { item ->
                    homeViewModel.onNavigationItemClick(
                        destination = item.destination,
                    )
                },
            )
        }

        composable(
            route = FitNestDestination.Profile.route,
        ) {
            val profileViewModel: ProfileViewModel =
                viewModel()

            val profileUiState by
            profileViewModel
                .uiState
                .collectAsStateWithLifecycle()

            ProfileScreen(
                state = profileUiState,
                onBackClick = {
                    navController.popBackStack()
                },
                onAvatarEditClick = {},
                onEditFieldClick = { field ->
                    profileViewModel.onEditFieldClick(
                        field = field,
                    )
                },
                onLogoutClick = {
                    profileViewModel.onLogoutClick()
                },
                onSaveClick = {
                    profileViewModel.onSaveClick()
                },
            )
        }
    }
}
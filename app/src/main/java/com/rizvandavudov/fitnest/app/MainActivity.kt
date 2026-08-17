package com.rizvandavudov.fitnest.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rizvandavudov.fitnest.core.designsystem.FitNestTheme
import com.rizvandavudov.fitnest.feature.home.HomeScreen
import com.rizvandavudov.fitnest.feature.home.HomeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            FitNestTheme {
                val homeViewModel: HomeViewModel = viewModel()

                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                HomeScreen(
                    state = homeUiState,
                    onProfileClick = {
                        // Profile navigation növbəti mərhələdə qoşulacaq.
                    },
                    onNotificationClick = {
                        // Bu texniki tapşırıqda ayrıca ekran yoxdur.
                    },
                    onCategoryClick = {
                        // Kateqoriya detalları tapşırığa daxil deyil.
                    },
                    onMarketSeeAllClick = {
                        // FitMarket siyahısı tapşırığa daxil deyil.
                    },
                    onMarketItemClick = {
                        // Məhsul detalları tapşırığa daxil deyil.
                    },
                    onMarketBookmarkClick = {
                        // Backend inteqrasiyası tələb edilmir.
                    },
                    onMarketActionClick = {
                        // Xarici keçid tapşırığa daxil deyil.
                    },
                    onGymsSeeAllClick = {
                        // Zallar siyahısı tapşırığa daxil deyil.
                    },
                    onGymClick = {
                        // Zal detalları tapşırığa daxil deyil.
                    },
                    onBottomNavigationItemClick = { item ->
                        homeViewModel.onNavigationItemClick(
                            destination = item.destination,
                        )
                    },
                )
            }
        }
    }
}
package com.rizvandavudov.fitnest.feature.home

import com.rizvandavudov.fitnest.feature.home.data.HomeDataSource
import com.rizvandavudov.fitnest.feature.home.ui.HomeUiState

class HomeUiMapper {

    fun map(
        dataSource: HomeDataSource,
    ): HomeUiState {
        return HomeUiState(
            isLoading = false,
            initials = dataSource.initials,
            greeting = dataSource.greeting,
            texts = dataSource.texts,
            categories = dataSource.categories,
            marketItems = dataSource.marketItems,
            gyms = dataSource.gyms,
            bottomNavigationItems =
                dataSource.bottomNavigationItems,
            selectedNavigationItem =
                dataSource.selectedNavigationItem,
        )
    }
}
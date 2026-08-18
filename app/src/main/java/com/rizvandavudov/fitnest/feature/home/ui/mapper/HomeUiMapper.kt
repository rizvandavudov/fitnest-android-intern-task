package com.rizvandavudov.fitnest.feature.home.ui.mapper

import com.rizvandavudov.fitnest.feature.home.HomeUiState
import com.rizvandavudov.fitnest.feature.home.data.HomeDataSource

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
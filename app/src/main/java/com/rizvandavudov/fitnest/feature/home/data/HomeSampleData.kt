package com.rizvandavudov.fitnest.feature.home.data

import com.rizvandavudov.fitnest.feature.home.HomeUiMapper
import com.rizvandavudov.fitnest.feature.home.ui.HomeUiState

object HomeSampleData {

    private val dataSource: HomeDataSource = FakeRepo()

    val state: HomeUiState = HomeUiMapper().map(
        dataSource = dataSource,
    )
}
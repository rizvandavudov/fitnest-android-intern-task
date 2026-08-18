package com.rizvandavudov.fitnest.feature.home

import com.rizvandavudov.fitnest.feature.home.data.FakeRepo
import com.rizvandavudov.fitnest.feature.home.data.HomeDataSource
import com.rizvandavudov.fitnest.feature.home.ui.mapper.HomeUiMapper

object HomeSampleData {

    private val dataSource: HomeDataSource = FakeRepo()

    val state: HomeUiState = HomeUiMapper().map(
        dataSource = dataSource,
    )
}
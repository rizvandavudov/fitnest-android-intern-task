package com.rizvandavudov.fitnest.feature.profile.data

import com.rizvandavudov.fitnest.feature.profile.ProfileUiMapper
import com.rizvandavudov.fitnest.feature.profile.ui.ProfileUiState

object ProfileSampleData {

    private val dataSource: ProfileDataSource =
        ProfileFakeRepo()

    val state: ProfileUiState = ProfileUiMapper().map(
        dataSource = dataSource,
    )
}
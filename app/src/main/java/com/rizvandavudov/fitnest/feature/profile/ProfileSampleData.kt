package com.rizvandavudov.fitnest.feature.profile

import com.rizvandavudov.fitnest.feature.profile.data.ProfileDataSource
import com.rizvandavudov.fitnest.feature.profile.data.ProfileFakeRepo
import com.rizvandavudov.fitnest.feature.profile.ui.mapper.ProfileUiMapper

object ProfileSampleData {

    private val dataSource: ProfileDataSource =
        ProfileFakeRepo()

    val state: ProfileUiState = ProfileUiMapper().map(
        dataSource = dataSource,
    )
}
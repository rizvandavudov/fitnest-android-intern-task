package com.rizvandavudov.fitnest.preview

import com.rizvandavudov.fitnest.feature.home.HomeSampleData
import com.rizvandavudov.fitnest.feature.home.HomeUiState
import com.rizvandavudov.fitnest.feature.profile.ProfileSampleData
import com.rizvandavudov.fitnest.feature.profile.ProfileUiState

object PreviewData {

    val homeUiState: HomeUiState =
        HomeSampleData.state

    val profileUiState: ProfileUiState =
        ProfileSampleData.state
}
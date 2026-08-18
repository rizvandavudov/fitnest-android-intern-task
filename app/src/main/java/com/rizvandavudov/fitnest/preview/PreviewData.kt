package com.rizvandavudov.fitnest.preview

import com.rizvandavudov.fitnest.feature.home.data.HomeSampleData
import com.rizvandavudov.fitnest.feature.home.ui.HomeUiState
import com.rizvandavudov.fitnest.feature.profile.data.ProfileSampleData
import com.rizvandavudov.fitnest.feature.profile.ui.ProfileUiState

object PreviewData {

    val homeUiState: HomeUiState =
        HomeSampleData.state

    val profileUiState: ProfileUiState =
        ProfileSampleData.state
}
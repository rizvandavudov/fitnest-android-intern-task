package com.rizvandavudov.fitnest.feature.profile.data

import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel
import com.rizvandavudov.fitnest.feature.profile.ProfileTextsUiModel
import com.rizvandavudov.fitnest.feature.profile.SubscriptionStatus

interface ProfileDataSource {

    val avatar: ThemedImageUiModel

    val userId: String

    val firstName: String

    val lastName: String

    val phoneNumber: String

    val email: String

    val subscriptionTitle: String

    val subscriptionStatus: SubscriptionStatus

    val texts: ProfileTextsUiModel
}
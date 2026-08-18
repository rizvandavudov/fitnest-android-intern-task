package com.rizvandavudov.fitnest.feature.profile

import com.rizvandavudov.fitnest.feature.profile.data.ProfileDataSource
import com.rizvandavudov.fitnest.feature.profile.ui.ProfileUiState
import com.rizvandavudov.fitnest.feature.profile.ui.SubscriptionUiModel

class ProfileUiMapper {

    fun map(
        dataSource: ProfileDataSource,
    ): ProfileUiState {
        return ProfileUiState(
            avatar = dataSource.avatar,
            userId = dataSource.userId,
            firstName = dataSource.firstName,
            lastName = dataSource.lastName,
            phoneNumber = dataSource.phoneNumber,
            email = dataSource.email,
            subscription = mapSubscription(
                dataSource = dataSource,
            ),
            texts = dataSource.texts,
        )
    }

    private fun mapSubscription(
        dataSource: ProfileDataSource,
    ): SubscriptionUiModel {
        return SubscriptionUiModel(
            title = dataSource.subscriptionTitle,
            statusLabel = dataSource.texts
                .subscriptionStatusLabel(
                    status = dataSource.subscriptionStatus,
                ),
            status = dataSource.subscriptionStatus,
        )
    }
}
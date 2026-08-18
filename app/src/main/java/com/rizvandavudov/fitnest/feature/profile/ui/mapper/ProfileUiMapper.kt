package com.rizvandavudov.fitnest.feature.profile.ui.mapper

import com.rizvandavudov.fitnest.feature.profile.ProfileUiState
import com.rizvandavudov.fitnest.feature.profile.SubscriptionUiModel
import com.rizvandavudov.fitnest.feature.profile.data.ProfileDataSource

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
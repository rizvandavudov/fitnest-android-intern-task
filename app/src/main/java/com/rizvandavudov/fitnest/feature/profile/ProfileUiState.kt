package com.rizvandavudov.fitnest.feature.profile

import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel

enum class SubscriptionStatus {
    ACTIVE,
    INACTIVE,
}

data class SubscriptionUiModel(
    val title: String,
    val statusLabel: String,
    val status: SubscriptionStatus,
)

data class ProfileUiState(
    val avatar: ThemedImageUiModel,
    val userId: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val subscription: SubscriptionUiModel,
)
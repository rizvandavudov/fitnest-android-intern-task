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

data class ProfileTextsUiModel(
    val title: String = "",
    val backContentDescription: String = "",
    val avatarContentDescription: String = "",
    val avatarEditContentDescription: String = "",
    val firstNameLabel: String = "",
    val lastNameLabel: String = "",
    val phoneLabel: String = "",
    val emailLabel: String = "",
    val subscriptionLabel: String = "",
    val userIconContentDescription: String = "",
    val phoneIconContentDescription: String = "",
    val emailIconContentDescription: String = "",
    val subscriptionIconContentDescription: String = "",
    val editFirstNameContentDescription: String = "",
    val editLastNameContentDescription: String = "",
    val editPhoneContentDescription: String = "",
    val editEmailContentDescription: String = "",
    val logoutTitle: String = "",
    val logoutDescription: String = "",
    val logoutContentDescription: String = "",
    val saveButtonText: String = "",
    val saveContentDescription: String = "",
    val subscriptionActiveLabel: String = "",
    val subscriptionInactiveLabel: String = "",
) {

    fun subscriptionStatusLabel(
        status: SubscriptionStatus,
    ): String {
        return when (status) {
            SubscriptionStatus.ACTIVE ->
                subscriptionActiveLabel

            SubscriptionStatus.INACTIVE ->
                subscriptionInactiveLabel
        }
    }
}

data class ProfileUiState(
    val avatar: ThemedImageUiModel,
    val userId: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val subscription: SubscriptionUiModel,
    val texts: ProfileTextsUiModel = ProfileTextsUiModel(),
)
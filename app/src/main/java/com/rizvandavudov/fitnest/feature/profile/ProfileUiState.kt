package com.rizvandavudov.fitnest.feature.profile

import androidx.annotation.DrawableRes

data class ProfileUiState(
    val isLoading: Boolean = false,
    val profileId: String = "",
    val avatarUrl: String = "",
    @param:DrawableRes
    val avatarFallbackResId: Int = 0,
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val currentPlan: String = "",
    val isSubscriptionActive: Boolean = false,
)
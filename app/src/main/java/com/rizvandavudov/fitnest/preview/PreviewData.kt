package com.rizvandavudov.fitnest.preview

import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.feature.home.HomeSampleData
import com.rizvandavudov.fitnest.feature.profile.ProfileUiState

object PreviewData {

    private const val RAW_IMAGE_BASE_URL =
        "https://raw.githubusercontent.com/rizvandavudov/" +
                "fitnest-android-intern-task/main/app/src/main/res/drawable-nodpi/"

    val homeUiState = HomeSampleData.state

    val profileUiState = ProfileUiState(
        profileId = "ID: 12345ADFSG",
        avatarUrl = imageUrl("profile_avatar_source.png"),
        avatarFallbackResId = R.drawable.profile_avatar_source,
        firstName = "Leyla",
        lastName = "Abdullayeva",
        phoneNumber = "+994 50 650 45 45",
        email = "leyla@gmail.com",
        currentPlan = "Premium Plan",
        isSubscriptionActive = true,
    )

    private fun imageUrl(fileName: String): String {
        return RAW_IMAGE_BASE_URL + fileName
    }
}
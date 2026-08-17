package com.rizvandavudov.fitnest.feature.profile

import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel

object ProfileSampleData {

    private const val RAW_IMAGE_BASE_URL =
        "https://raw.githubusercontent.com/rizvandavudov/" +
                "fitnest-android-intern-task/main/" +
                "app/src/main/res/drawable-nodpi/"

    val state = ProfileUiState(
        avatar = ThemedImageUiModel(
            lightUrl = imageUrl(
                fileName = "profile_avatar_source.png",
            ),
            lightFallbackResId =
                R.drawable.profile_avatar_source,
        ),
        userId = "12345ADFSG",
        firstName = "Leyla",
        lastName = "Abdullayeva",
        phoneNumber = "+994 50 650 45 45",
        email = "leyla@gmail.com",
        subscription = SubscriptionUiModel(
            title = "Premium Plan",
            statusLabel = "Aktiv",
            status = SubscriptionStatus.ACTIVE,
        ),
    )

    private fun imageUrl(
        fileName: String,
    ): String {
        return RAW_IMAGE_BASE_URL + fileName
    }
}
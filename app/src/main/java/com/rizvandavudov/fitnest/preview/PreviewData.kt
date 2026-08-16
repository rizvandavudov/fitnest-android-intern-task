package com.rizvandavudov.fitnest.preview

import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel
import com.rizvandavudov.fitnest.feature.home.CategoryUiModel
import com.rizvandavudov.fitnest.feature.home.GymUiModel
import com.rizvandavudov.fitnest.feature.home.HomeUiState
import com.rizvandavudov.fitnest.feature.home.MarketProductUiModel
import com.rizvandavudov.fitnest.feature.profile.ProfileUiState

object PreviewData {

    private const val RAW_IMAGE_BASE_URL =
        "https://raw.githubusercontent.com/rizvandavudov/" +
                "fitnest-android-intern-task/main/app/src/main/res/drawable-nodpi/"

    val homeUiState = HomeUiState(
        userInitials = "AS",
        greeting = "Salam, Nigar!",
        categories = listOf(
            CategoryUiModel(
                id = "fitness",
                title = "Fitness",
                image = ThemedImageUiModel(
                    lightUrl = imageUrl("home_light_category_fitness.png"),
                    darkUrl = imageUrl("home_dark_category_fitness.png"),
                    lightFallbackResId = R.drawable.home_light_category_fitness,
                    darkFallbackResId = R.drawable.home_dark_category_fitness,
                ),
            ),
            CategoryUiModel(
                id = "pilates",
                title = "Pilates",
                image = ThemedImageUiModel(
                    lightUrl = imageUrl("home_light_category_pilates.png"),
                    darkUrl = imageUrl("home_dark_category_pilates.png"),
                    lightFallbackResId = R.drawable.home_light_category_pilates,
                    darkFallbackResId = R.drawable.home_dark_category_pilates,
                ),
            ),
            CategoryUiModel(
                id = "combat",
                title = "Döyüş növləri",
                image = ThemedImageUiModel(
                    lightUrl = imageUrl("home_light_category_combat.png"),
                    darkUrl = imageUrl("home_dark_category_combat.png"),
                    lightFallbackResId = R.drawable.home_light_category_combat,
                    darkFallbackResId = R.drawable.home_dark_category_combat,
                ),
            ),
            CategoryUiModel(
                id = "yoga",
                title = "Yoga",
                image = ThemedImageUiModel(
                    lightUrl = imageUrl("home_shared_category_yoga.png"),
                    lightFallbackResId = R.drawable.home_shared_category_yoga,
                ),
            ),
            CategoryUiModel(
                id = "spa_massage",
                title = "Spa və masaj",
                image = ThemedImageUiModel(
                    lightUrl = imageUrl("home_shared_category_spa_massage.png"),
                    lightFallbackResId = R.drawable.home_shared_category_spa_massage,
                ),
            ),
            CategoryUiModel(
                id = "cosmetology",
                title = "Kosmetoloji",
                image = ThemedImageUiModel(
                    lightUrl = imageUrl("home_shared_category_cosmetology.png"),
                    lightFallbackResId = R.drawable.home_shared_category_cosmetology,
                ),
            ),
        ),
        marketProducts = listOf(
            MarketProductUiModel(
                id = "vitamin_house_primary",
                storeName = "Vitamin House",
                address = "Bakı şəhəri, Mehdi Abbasov küçəsi 10/4",
                discountText = "5 %",
                actionText = "Keçid et",
                imageUrl = imageUrl("home_fitmarket_product_primary.png"),
                fallbackResId = R.drawable.home_fitmarket_product_primary,
            ),
            MarketProductUiModel(
                id = "vitamin_house_secondary",
                storeName = "Vitamin House",
                address = "Bakı şəhəri, Mehdi Abbasov küçəsi 10/4",
                discountText = "5 %",
                actionText = "Keçid et",
                imageUrl = imageUrl("home_fitmarket_product_secondary.png"),
                fallbackResId = R.drawable.home_fitmarket_product_secondary,
            ),
        ),
        gyms = listOf(
            GymUiModel(
                id = "pulse_gym_primary",
                name = "Pulse Gym",
                distanceText = "Sizdən 12.2 km uzaqlıqda",
                rating = "4.5",
                badgeText = "Yeni",
                image = ThemedImageUiModel(
                    lightUrl = imageUrl("home_light_gym_primary.png"),
                    darkUrl = imageUrl("home_dark_gym_shared.png"),
                    lightFallbackResId = R.drawable.home_light_gym_primary,
                    darkFallbackResId = R.drawable.home_dark_gym_shared,
                ),
            ),
            GymUiModel(
                id = "pulse_gym_secondary",
                name = "Pulse Gym",
                distanceText = "Sizdən 12.2 km uzaqlıqda",
                rating = "4.5",
                badgeText = null,
                image = ThemedImageUiModel(
                    lightUrl = imageUrl("home_light_gym_secondary.png"),
                    darkUrl = imageUrl("home_dark_gym_shared.png"),
                    lightFallbackResId = R.drawable.home_light_gym_secondary,
                    darkFallbackResId = R.drawable.home_dark_gym_shared,
                ),
            ),
        ),
    )

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
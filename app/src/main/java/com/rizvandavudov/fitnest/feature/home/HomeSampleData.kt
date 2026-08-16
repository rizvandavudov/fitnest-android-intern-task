package com.rizvandavudov.fitnest.feature.home

import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel

object HomeSampleData {

    private const val RAW_IMAGE_BASE_URL =
        "https://raw.githubusercontent.com/rizvandavudov/" + "fitnest-android-intern-task/main/app/src/main/res/drawable-nodpi/"

    private val categories = listOf(
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
    )

    private val marketItems = listOf(
        MarketItemUiModel(
            id = "vitamin_house_primary",
            storeName = "Vitamin House",
            address = "Bakı şəhəri, Mehdi Abbasov küçəsi 10/4",
            discountText = "5 %",
            actionText = "Keçid et",
            image = ThemedImageUiModel(
                lightUrl = imageUrl("home_fitmarket_product_primary.png"),
                lightFallbackResId = R.drawable.home_fitmarket_product_primary,
            ),
        ),
        MarketItemUiModel(
            id = "vitamin_house_secondary",
            storeName = "Vitamin House",
            address = "Bakı şəhəri, Mehdi Abbasov küçəsi 10/4",
            discountText = "5 %",
            actionText = "Keçid et",
            image = ThemedImageUiModel(
                lightUrl = imageUrl("home_fitmarket_product_secondary.png"),
                lightFallbackResId = R.drawable.home_fitmarket_product_secondary,
            ),
        ),
    )

    private val gyms = listOf(
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
    )

    private val bottomNavigationItems = listOf(
        BottomNavigationItemUiModel(
            destination = BottomNavigationDestination.HOME,
            label = "Əsas səhifə",
            isEnabled = true,
        ),
        BottomNavigationItemUiModel(
            destination = BottomNavigationDestination.SEARCH,
            label = "Axtarış",
            isEnabled = false,
        ),
        BottomNavigationItemUiModel(
            destination = BottomNavigationDestination.QR,
            label = "QR",
            isEnabled = false,
        ),
        BottomNavigationItemUiModel(
            destination = BottomNavigationDestination.SUBSCRIPTION,
            label = "Abunəlik",
            isEnabled = false,
        ),
        BottomNavigationItemUiModel(
            destination = BottomNavigationDestination.MORE,
            label = "Daha çox",
            isEnabled = false,
        ),
    )

    val state = HomeUiState(
        initials = "AS",
        greeting = "Salam, Nigar!",
        categories = categories,
        marketItems = marketItems,
        gyms = gyms,
        bottomNavigationItems = bottomNavigationItems,
        selectedNavigationItem = BottomNavigationDestination.HOME,
    )

    private fun imageUrl(fileName: String): String {
        return RAW_IMAGE_BASE_URL + fileName
    }
}
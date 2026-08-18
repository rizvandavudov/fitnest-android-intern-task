package com.rizvandavudov.fitnest.feature.home.data

import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel
import com.rizvandavudov.fitnest.feature.home.ui.BottomNavigationDestination
import com.rizvandavudov.fitnest.feature.home.ui.BottomNavigationItemUiModel
import com.rizvandavudov.fitnest.feature.home.ui.CategoryLightAppearance
import com.rizvandavudov.fitnest.feature.home.ui.CategoryUiModel
import com.rizvandavudov.fitnest.feature.home.ui.GymLightOverlayStyle
import com.rizvandavudov.fitnest.feature.home.ui.GymUiModel
import com.rizvandavudov.fitnest.feature.home.ui.HomeTextsUiModel
import com.rizvandavudov.fitnest.feature.home.ui.MarketImageSizeStyle
import com.rizvandavudov.fitnest.feature.home.ui.MarketItemUiModel

class FakeRepo : HomeDataSource {

    override val initials: String = "AS"

    override val greeting: String = "Salam, Nigar!"

    override val texts: HomeTextsUiModel =
        HomeTextsUiModel(
            profileContentDescription = "Profil",
            notificationContentDescription = "Bildirişlər",
            seeMoreLabel = "Daha çox",
            marketTitle = "FitMarket",
            marketSeeMoreContentDescription =
                "FitMarket bölməsində daha çox məhsula bax",
            marketCardContentDescriptionSuffix =
                "mağaza kartı",
            marketBookmarkContentDescriptionSuffix =
                "mağazasını seçilmişlərə əlavə et",
            marketActionContentDescriptionSuffix =
                "mağazasına keçid et",
            nearbyGymsTitle = "Yaxınlıqdakı zallar",
            gymsSeeMoreContentDescription =
                "Yaxınlıqdakı zalların hamısına bax",
            gymRatingLabel = "reytinq",
        )

    override val categories: List<CategoryUiModel> = listOf(
        CategoryUiModel(
            id = "fitness",
            title = "Fitness",
            lightAppearance =
                CategoryLightAppearance.LIGHT_OVERLAY,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_light_category_fitness.png",
                ),
                darkUrl = imageUrl(
                    "home_dark_category_fitness.png",
                ),
                lightFallbackResId =
                    R.drawable.home_light_category_fitness,
                darkFallbackResId =
                    R.drawable.home_dark_category_fitness,
            ),
        ),
        CategoryUiModel(
            id = "pilates",
            title = "Pilates",
            lightAppearance =
                CategoryLightAppearance.LIGHT_OVERLAY,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_light_category_pilates.png",
                ),
                darkUrl = imageUrl(
                    "home_dark_category_pilates.png",
                ),
                lightFallbackResId =
                    R.drawable.home_light_category_pilates,
                darkFallbackResId =
                    R.drawable.home_dark_category_pilates,
            ),
        ),
        CategoryUiModel(
            id = "combat",
            title = "Döyüş növləri",
            lightAppearance =
                CategoryLightAppearance.LIGHT_OVERLAY,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_light_category_combat.png",
                ),
                darkUrl = imageUrl(
                    "home_dark_category_combat.png",
                ),
                lightFallbackResId =
                    R.drawable.home_light_category_combat,
                darkFallbackResId =
                    R.drawable.home_dark_category_combat,
            ),
        ),
        CategoryUiModel(
            id = "yoga",
            title = "Yoga",
            lightAppearance =
                CategoryLightAppearance.DARK_OVERLAY,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_shared_category_yoga.png",
                ),
                lightFallbackResId =
                    R.drawable.home_shared_category_yoga,
            ),
        ),
        CategoryUiModel(
            id = "spa_massage",
            title = "Spa və masaj",
            lightAppearance =
                CategoryLightAppearance.DARK_OVERLAY,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_shared_category_spa_massage.png",
                ),
                lightFallbackResId =
                    R.drawable.home_shared_category_spa_massage,
            ),
        ),
        CategoryUiModel(
            id = "cosmetology",
            title = "Kosmetoloji",
            lightAppearance =
                CategoryLightAppearance.DARK_OVERLAY,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_shared_category_cosmetology.png",
                ),
                lightFallbackResId =
                    R.drawable.home_shared_category_cosmetology,
            ),
        ),
    )

    override val marketItems: List<MarketItemUiModel> = listOf(
        MarketItemUiModel(
            id = "vitamin_house_primary",
            storeName = "Vitamin House",
            address = "Bakı şəhəri, Mehdi Abbasov küçəsi 10/4",
            discountText = "5 %",
            actionText = "Keçid et",
            imageSizeStyle = MarketImageSizeStyle.FEATURED,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_fitmarket_product_primary.png",
                ),
                lightFallbackResId =
                    R.drawable.home_fitmarket_product_primary,
            ),
        ),
        MarketItemUiModel(
            id = "vitamin_house_secondary",
            storeName = "Vitamin House",
            address = "Bakı şəhəri, Mehdi Abbasov küçəsi 10/4",
            discountText = "5 %",
            actionText = "Keçid et",
            imageSizeStyle = MarketImageSizeStyle.STANDARD,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_fitmarket_product_secondary.png",
                ),
                lightFallbackResId =
                    R.drawable.home_fitmarket_product_secondary,
            ),
        ),
    )

    override val gyms: List<GymUiModel> = listOf(
        GymUiModel(
            id = "pulse_gym_primary",
            name = "Pulse Gym",
            distanceText = "Sizdən 12.2 km uzaqlıqda",
            rating = "4.5",
            badgeText = "Yeni",
            lightOverlayStyle = GymLightOverlayStyle.STRONG,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_light_gym_primary.png",
                ),
                darkUrl = imageUrl(
                    "home_dark_gym_shared.png",
                ),
                lightFallbackResId =
                    R.drawable.home_light_gym_primary,
                darkFallbackResId =
                    R.drawable.home_dark_gym_shared,
            ),
        ),
        GymUiModel(
            id = "pulse_gym_secondary",
            name = "Pulse Gym",
            distanceText = "Sizdən 12.2 km uzaqlıqda",
            rating = "4.5",
            badgeText = null,
            lightOverlayStyle = GymLightOverlayStyle.SOFT,
            image = ThemedImageUiModel(
                lightUrl = imageUrl(
                    "home_light_gym_secondary.png",
                ),
                darkUrl = imageUrl(
                    "home_dark_gym_shared.png",
                ),
                lightFallbackResId =
                    R.drawable.home_light_gym_secondary,
                darkFallbackResId =
                    R.drawable.home_dark_gym_shared,
            ),
        ),
    )

    override val bottomNavigationItems:
            List<BottomNavigationItemUiModel> = listOf(
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
            destination =
                BottomNavigationDestination.SUBSCRIPTION,
            label = "Abunəlik",
            isEnabled = false,
        ),
        BottomNavigationItemUiModel(
            destination = BottomNavigationDestination.MORE,
            label = "Daha çox",
            isEnabled = false,
        ),
    )

    override val selectedNavigationItem:
            BottomNavigationDestination =
        BottomNavigationDestination.HOME

    private fun imageUrl(
        fileName: String,
    ): String {
        return RAW_IMAGE_BASE_URL + fileName
    }

    private companion object {

        const val RAW_IMAGE_BASE_URL =
            "https://raw.githubusercontent.com/rizvandavudov/" +
                    "fitnest-android-intern-task/main/" +
                    "app/src/main/res/drawable-nodpi/"
    }
}
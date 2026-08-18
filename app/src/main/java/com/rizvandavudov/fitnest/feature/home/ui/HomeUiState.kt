package com.rizvandavudov.fitnest.feature.home.ui

import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel

enum class CategoryLightAppearance {
    LIGHT_OVERLAY,
    DARK_OVERLAY,
}

data class CategoryUiModel(
    val id: String,
    val title: String,
    val image: ThemedImageUiModel,
    val lightAppearance: CategoryLightAppearance,
)

enum class MarketImageSizeStyle {
    FEATURED,
    STANDARD,
}

data class MarketItemUiModel(
    val id: String,
    val storeName: String,
    val address: String,
    val discountText: String,
    val actionText: String,
    val image: ThemedImageUiModel,
    val imageSizeStyle: MarketImageSizeStyle,
)

enum class GymLightOverlayStyle {
    STRONG,
    SOFT,
}

data class GymUiModel(
    val id: String,
    val name: String,
    val distanceText: String,
    val rating: String,
    val badgeText: String?,
    val image: ThemedImageUiModel,
    val lightOverlayStyle: GymLightOverlayStyle,
)

enum class BottomNavigationDestination {
    HOME,
    SEARCH,
    QR,
    SUBSCRIPTION,
    MORE,
}

data class BottomNavigationItemUiModel(
    val destination: BottomNavigationDestination,
    val label: String,
    val isEnabled: Boolean,
)

data class HomeTextsUiModel(
    val profileContentDescription: String = "",
    val notificationContentDescription: String = "",
    val seeMoreLabel: String = "",
    val marketTitle: String = "",
    val marketSeeMoreContentDescription: String = "",
    val marketCardContentDescriptionSuffix: String = "",
    val marketBookmarkContentDescriptionSuffix: String = "",
    val marketActionContentDescriptionSuffix: String = "",
    val nearbyGymsTitle: String = "",
    val gymsSeeMoreContentDescription: String = "",
    val gymRatingLabel: String = "",
) {

    fun marketCardContentDescription(
        storeName: String,
    ): String {
        return "$storeName " +
                marketCardContentDescriptionSuffix
    }

    fun marketBookmarkContentDescription(
        storeName: String,
    ): String {
        return "$storeName " +
                marketBookmarkContentDescriptionSuffix
    }

    fun marketActionContentDescription(
        storeName: String,
    ): String {
        return "$storeName " +
                marketActionContentDescriptionSuffix
    }

    fun gymContentDescription(
        gym: GymUiModel,
    ): String {
        return "${gym.name}, ${gym.rating} " +
                "$gymRatingLabel, " +
                gym.distanceText
    }
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val initials: String = "",
    val greeting: String = "",
    val texts: HomeTextsUiModel = HomeTextsUiModel(),
    val categories: List<CategoryUiModel> = emptyList(),
    val marketItems: List<MarketItemUiModel> = emptyList(),
    val gyms: List<GymUiModel> = emptyList(),
    val bottomNavigationItems:
    List<BottomNavigationItemUiModel> = emptyList(),
    val selectedNavigationItem: BottomNavigationDestination =
        BottomNavigationDestination.HOME,
)
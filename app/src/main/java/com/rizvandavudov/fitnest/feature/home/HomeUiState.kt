package com.rizvandavudov.fitnest.feature.home

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

data class HomeUiState(
    val isLoading: Boolean = false,
    val initials: String = "",
    val greeting: String = "",
    val categories: List<CategoryUiModel> = emptyList(),
    val marketItems: List<MarketItemUiModel> = emptyList(),
    val gyms: List<GymUiModel> = emptyList(),
    val bottomNavigationItems: List<BottomNavigationItemUiModel> = emptyList(),
    val selectedNavigationItem: BottomNavigationDestination =
        BottomNavigationDestination.HOME,
)
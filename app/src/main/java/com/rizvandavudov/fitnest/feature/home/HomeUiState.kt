package com.rizvandavudov.fitnest.feature.home

import androidx.annotation.DrawableRes
import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel

data class HomeUiState(
    val isLoading: Boolean = false,
    val userInitials: String = "",
    val greeting: String = "",
    val categories: List<CategoryUiModel> = emptyList(),
    val marketProducts: List<MarketProductUiModel> = emptyList(),
    val gyms: List<GymUiModel> = emptyList(),
)

data class CategoryUiModel(
    val id: String,
    val title: String,
    val image: ThemedImageUiModel,
)

data class MarketProductUiModel(
    val id: String,
    val storeName: String,
    val address: String,
    val discountText: String,
    val actionText: String,
    val imageUrl: String,
    @param:DrawableRes
    val fallbackResId: Int,
)

data class GymUiModel(
    val id: String,
    val name: String,
    val distanceText: String,
    val rating: String,
    val badgeText: String?,
    val image: ThemedImageUiModel,
)
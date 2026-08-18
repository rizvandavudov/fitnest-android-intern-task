package com.rizvandavudov.fitnest.feature.home.data

import com.rizvandavudov.fitnest.feature.home.BottomNavigationDestination
import com.rizvandavudov.fitnest.feature.home.BottomNavigationItemUiModel
import com.rizvandavudov.fitnest.feature.home.CategoryUiModel
import com.rizvandavudov.fitnest.feature.home.GymUiModel
import com.rizvandavudov.fitnest.feature.home.HomeTextsUiModel
import com.rizvandavudov.fitnest.feature.home.MarketItemUiModel

interface HomeDataSource {

    val initials: String

    val greeting: String

    val texts: HomeTextsUiModel

    val categories: List<CategoryUiModel>

    val marketItems: List<MarketItemUiModel>

    val gyms: List<GymUiModel>

    val bottomNavigationItems:
            List<BottomNavigationItemUiModel>

    val selectedNavigationItem:
            BottomNavigationDestination
}
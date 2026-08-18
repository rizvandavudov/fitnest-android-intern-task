package com.rizvandavudov.fitnest.feature.home.data

import com.rizvandavudov.fitnest.feature.home.ui.BottomNavigationDestination
import com.rizvandavudov.fitnest.feature.home.ui.BottomNavigationItemUiModel
import com.rizvandavudov.fitnest.feature.home.ui.CategoryUiModel
import com.rizvandavudov.fitnest.feature.home.ui.GymUiModel
import com.rizvandavudov.fitnest.feature.home.ui.HomeTextsUiModel
import com.rizvandavudov.fitnest.feature.home.ui.MarketItemUiModel

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
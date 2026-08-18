package com.rizvandavudov.fitnest.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.feature.home.ui.components.CategoryRow
import com.rizvandavudov.fitnest.feature.home.ui.components.FitNestBottomBar
import com.rizvandavudov.fitnest.feature.home.ui.components.HomeHeader
import com.rizvandavudov.fitnest.feature.home.ui.components.MarketSection
import com.rizvandavudov.fitnest.feature.home.ui.components.NearbyGymsSection
import com.rizvandavudov.fitnest.preview.FitNestHomePreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.FitNestResponsivePreviews

@Composable
fun HomeScreen(
    state: HomeUiState,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onCategoryClick: (CategoryUiModel) -> Unit,
    onMarketSeeAllClick: () -> Unit,
    onMarketItemClick: (MarketItemUiModel) -> Unit,
    onMarketBookmarkClick: (MarketItemUiModel) -> Unit,
    onMarketActionClick: (MarketItemUiModel) -> Unit,
    onGymsSeeAllClick: () -> Unit,
    onGymClick: (GymUiModel) -> Unit,
    onBottomNavigationItemClick:
        (BottomNavigationItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors

    val texts = state.texts

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colors.screenBackground,
        contentWindowInsets = WindowInsets(
            left = 0,
            top = 0,
            right = 0,
            bottom = 0,
        ),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentPadding = PaddingValues(
                    bottom = FitNestDimens.contentSpacing,
                ),
            ) {
                item(key = "home_header") {
                    HomeHeader(
                        initials = state.initials,
                        greeting = state.greeting,
                        avatarContentDescription =
                            texts.profileContentDescription,
                        notificationContentDescription =
                            texts.notificationContentDescription,
                        onAvatarClick = onProfileClick,
                        onNotificationClick =
                            onNotificationClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .statusBarsPadding()
                            .padding(
                                start =
                                    FitNestDimens
                                        .screenHorizontalPadding,
                                top =
                                    FitNestDimens
                                        .homeHeaderTopSpacing,
                                end =
                                    FitNestDimens
                                        .screenHorizontalPadding,
                            ),
                    )
                }

                item(key = "header_category_spacing") {
                    Spacer(
                        modifier = Modifier.height(
                            FitNestDimens
                                .homeHeaderToCategoriesSpacing,
                        ),
                    )
                }

                item(key = "categories") {
                    CategoryRow(
                        categories = state.categories,
                        onCategoryClick = onCategoryClick,
                    )
                }

                item(key = "categories_market_spacing") {
                    Spacer(
                        modifier = Modifier.height(
                            FitNestDimens.sectionSpacing,
                        ),
                    )
                }

                item(key = "market") {
                    MarketSection(
                        title = texts.marketTitle,
                        actionLabel = texts.seeMoreLabel,
                        actionContentDescription =
                            texts.marketSeeMoreContentDescription,
                        marketItems = state.marketItems,
                        cardContentDescription = { item ->
                            texts.marketCardContentDescription(
                                storeName = item.storeName,
                            )
                        },
                        bookmarkContentDescription = { item ->
                            texts.marketBookmarkContentDescription(
                                storeName = item.storeName,
                            )
                        },
                        marketActionContentDescription = { item ->
                            texts.marketActionContentDescription(
                                storeName = item.storeName,
                            )
                        },
                        onSeeAllClick = onMarketSeeAllClick,
                        onMarketItemClick = onMarketItemClick,
                        onBookmarkClick =
                            onMarketBookmarkClick,
                        onMarketActionClick =
                            onMarketActionClick,
                    )
                }

                item(key = "market_gyms_spacing") {
                    Spacer(
                        modifier = Modifier.height(
                            FitNestDimens.sectionSpacing,
                        ),
                    )
                }

                item(key = "nearby_gyms") {
                    NearbyGymsSection(
                        title = texts.nearbyGymsTitle,
                        actionLabel = texts.seeMoreLabel,
                        actionContentDescription =
                            texts.gymsSeeMoreContentDescription,
                        gyms = state.gyms,
                        gymContentDescription = { gym ->
                            texts.gymContentDescription(
                                gym = gym,
                            )
                        },
                        onSeeAllClick = onGymsSeeAllClick,
                        onGymClick = onGymClick,
                    )
                }
            }

            FitNestBottomBar(
                items = state.bottomNavigationItems,
                selectedDestination =
                    state.selectedNavigationItem,
                itemContentDescription = { item ->
                    item.label
                },
                onItemClick =
                    onBottomNavigationItemClick,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@FitNestHomePreviews
@Composable
private fun HomeScreenPreview() {
    FitNestPreview {
        HomeScreen(
            state = HomeSampleData.state,
            onProfileClick = {},
            onNotificationClick = {},
            onCategoryClick = {},
            onMarketSeeAllClick = {},
            onMarketItemClick = {},
            onMarketBookmarkClick = {},
            onMarketActionClick = {},
            onGymsSeeAllClick = {},
            onGymClick = {},
            onBottomNavigationItemClick = {},
        )
    }
}

@FitNestResponsivePreviews
@Composable
private fun HomeResponsivePreview() {
    FitNestPreview {
        HomeScreen(
            state = HomeSampleData.state,
            onProfileClick = {},
            onNotificationClick = {},
            onCategoryClick = {},
            onMarketSeeAllClick = {},
            onMarketItemClick = {},
            onMarketBookmarkClick = {},
            onMarketActionClick = {},
            onGymsSeeAllClick = {},
            onGymClick = {},
            onBottomNavigationItemClick = {},
        )
    }
}
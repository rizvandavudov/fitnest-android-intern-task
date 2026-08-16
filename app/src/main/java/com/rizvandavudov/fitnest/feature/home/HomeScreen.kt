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
import androidx.compose.ui.res.stringResource
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.feature.home.components.CategoryRow
import com.rizvandavudov.fitnest.feature.home.components.FitNestBottomBar
import com.rizvandavudov.fitnest.feature.home.components.HomeHeader
import com.rizvandavudov.fitnest.feature.home.components.MarketSection
import com.rizvandavudov.fitnest.feature.home.components.NearbyGymsSection
import com.rizvandavudov.fitnest.preview.FitNestHomePreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview

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

    val marketTitle = stringResource(
        R.string.home_market_title,
    )
    val nearbyGymsTitle = stringResource(
        R.string.home_nearby_gyms_title,
    )
    val seeMoreLabel = stringResource(
        R.string.home_see_more,
    )

    val profileContentDescription = stringResource(
        R.string.home_profile_content_description,
    )
    val notificationContentDescription = stringResource(
        R.string.home_notifications_content_description,
    )
    val marketSeeMoreContentDescription = stringResource(
        R.string.home_market_see_more_content_description,
    )
    val gymsSeeMoreContentDescription = stringResource(
        R.string.home_gyms_see_more_content_description,
    )

    val marketCardSuffix = stringResource(
        R.string.home_market_card_suffix,
    )
    val marketBookmarkSuffix = stringResource(
        R.string.home_market_bookmark_suffix,
    )
    val marketActionSuffix = stringResource(
        R.string.home_market_action_suffix,
    )
    val gymRatingLabel = stringResource(
        R.string.home_gym_rating_label,
    )

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
                            profileContentDescription,
                        notificationContentDescription =
                            notificationContentDescription,
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
                        title = marketTitle,
                        actionLabel = seeMoreLabel,
                        actionContentDescription =
                            marketSeeMoreContentDescription,
                        marketItems = state.marketItems,
                        cardContentDescription = { item ->
                            "${item.storeName} $marketCardSuffix"
                        },
                        bookmarkContentDescription = { item ->
                            "${item.storeName} $marketBookmarkSuffix"
                        },
                        marketActionContentDescription = { item ->
                            "${item.storeName} $marketActionSuffix"
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
                        title = nearbyGymsTitle,
                        actionLabel = seeMoreLabel,
                        actionContentDescription =
                            gymsSeeMoreContentDescription,
                        gyms = state.gyms,
                        gymContentDescription = { gym ->
                            "${gym.name}, ${gym.rating} " +
                                    "$gymRatingLabel, " +
                                    gym.distanceText
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
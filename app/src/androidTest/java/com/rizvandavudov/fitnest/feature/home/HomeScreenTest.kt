package com.rizvandavudov.fitnest.feature.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rizvandavudov.fitnest.core.designsystem.FitNestTheme
import com.rizvandavudov.fitnest.feature.home.data.HomeSampleData
import com.rizvandavudov.fitnest.feature.home.ui.HomeScreen
import com.rizvandavudov.fitnest.feature.home.ui.components.HomeHeader
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_displaysMainTexts() {
        composeTestRule.setContent {
            FitNestTheme {
                HomeScreen(
                    state = HomeSampleData.state.copy(
                        categories = emptyList(),
                        marketItems = emptyList(),
                        gyms = emptyList(),
                    ),
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

        composeTestRule
            .onNodeWithText("Salam, Nigar!")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("FitMarket")
            .assertIsDisplayed()
    }

    @Test
    fun avatarClick_invokesProfileCallback() {
        var profileClicked = false

        composeTestRule.setContent {
            FitNestTheme {
                HomeHeader(
                    initials = "AS",
                    greeting = "Salam, Nigar!",
                    avatarContentDescription = "Profilə keç",
                    notificationContentDescription =
                        "Bildirişlər",
                    onAvatarClick = {
                        profileClicked = true
                    },
                    onNotificationClick = {},
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Profilə keç")
            .performClick()

        composeTestRule.runOnIdle {
            assertTrue(profileClicked)
        }
    }
}
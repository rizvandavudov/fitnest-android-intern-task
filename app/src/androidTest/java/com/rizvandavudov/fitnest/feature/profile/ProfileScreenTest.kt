package com.rizvandavudov.fitnest.feature.profile

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rizvandavudov.fitnest.core.designsystem.FitNestTheme
import com.rizvandavudov.fitnest.feature.profile.components.ProfileTopBar
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun profileScreen_displaysProfileInformation() {
        composeTestRule.setContent {
            FitNestTheme {
                ProfileScreen(
                    state = ProfileSampleData.state.copy(
                        avatar = ProfileSampleData.state.avatar.copy(
                            lightUrl = "",
                            darkUrl = "",
                        ),
                    ),
                    onBackClick = {},
                    onAvatarEditClick = {},
                    onEditFieldClick = {},
                    onLogoutClick = {},
                    onSaveClick = {},
                )
            }
        }

        composeTestRule
            .onNodeWithText("Profil")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Leyla")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Yadda saxla")
            .assertIsDisplayed()
    }

    @Test
    fun backClick_invokesCallback() {
        var backClicked = false

        composeTestRule.setContent {
            FitNestTheme {
                ProfileTopBar(
                    title = "Profil",
                    backContentDescription = "Geri qayıt",
                    onBackClick = {
                        backClicked = true
                    },
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Geri qayıt")
            .performClick()

        composeTestRule.runOnIdle {
            assertTrue(backClicked)
        }
    }
}
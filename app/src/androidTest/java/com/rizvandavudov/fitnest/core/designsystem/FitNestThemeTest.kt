package com.rizvandavudov.fitnest.core.designsystem

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FitNestThemeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun lightTheme_rendersContent() {
        composeTestRule.setContent {
            FitNestTheme(
                darkTheme = false,
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme
                        .fitNestColors
                        .screenBackground,
                ) {
                    Text(text = "Light theme")
                }
            }
        }

        composeTestRule
            .onNodeWithText("Light theme")
            .assertIsDisplayed()
    }

    @Test
    fun darkTheme_rendersContent() {
        composeTestRule.setContent {
            FitNestTheme(
                darkTheme = true,
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme
                        .fitNestColors
                        .screenBackground,
                ) {
                    Text(text = "Dark theme")
                }
            }
        }

        composeTestRule
            .onNodeWithText("Dark theme")
            .assertIsDisplayed()
    }
}
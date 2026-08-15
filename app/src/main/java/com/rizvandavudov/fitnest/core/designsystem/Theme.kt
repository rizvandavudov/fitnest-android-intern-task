package com.rizvandavudov.fitnest.core.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val MaterialTheme.fitNestColors: FitNestColors
    @Composable
    @ReadOnlyComposable
    get() = LocalFitNestColors.current

val MaterialTheme.fitNestTypography: FitNestTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalFitNestTypography.current

val MaterialTheme.fitNestShapes: FitNestShapes
    @Composable
    @ReadOnlyComposable
    get() = LocalFitNestShapes.current

@Composable
fun FitNestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val materialColorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val fitNestColors = if (darkTheme) {
        DarkFitNestColors
    } else {
        LightFitNestColors
    }

    CompositionLocalProvider(
        LocalFitNestColors provides fitNestColors,
        LocalFitNestTypography provides DefaultFitNestTypography,
        LocalFitNestShapes provides DefaultFitNestShapes,
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = MaterialTypography,
            shapes = MaterialShapes,
            content = content,
        )
    }
}

@Composable
private fun FitNestThemePreviewContent() {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography
    val shapes = MaterialTheme.fitNestShapes

    Surface(
        color = colors.screenBackground,
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
        ) {
            Text(
                text = "Salam, Nigar!",
                style = typography.greeting,
                color = colors.primaryText,
                maxLines = 1,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "FitMarket",
                style = typography.marketTitle,
                color = colors.primaryText,
                maxLines = 1,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                color = colors.primaryAction,
                shape = shapes.button,
            ) {
                Text(
                    text = "Yadda saxla",
                    style = typography.buttonLabel,
                    color = colors.onPrimaryAction,
                    modifier = Modifier.padding(
                        horizontal = 24.dp,
                        vertical = 13.dp,
                    ),
                    maxLines = 1,
                )
            }
        }
    }
}

@Preview(
    name = "FitNest Light Theme",
    showBackground = true,
)
@Composable
private fun FitNestLightThemePreview() {
    FitNestTheme(
        darkTheme = false,
    ) {
        FitNestThemePreviewContent()
    }
}

@Preview(
    name = "FitNest Dark Theme",
    showBackground = true,
    backgroundColor = 0xFF030510,
)
@Composable
private fun FitNestDarkThemePreview() {
    FitNestTheme(
        darkTheme = true,
    ) {
        FitNestThemePreviewContent()
    }
}
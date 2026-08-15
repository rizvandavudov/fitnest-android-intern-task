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
    ) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = Typography,
            content = content,
        )
    }
}

@Composable
private fun FitNestThemePreviewContent() {
    val colors = MaterialTheme.fitNestColors

    Surface(
        color = colors.screenBackground,
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
        ) {
            Text(
                text = "FitNest primary text",
                color = colors.primaryText,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "FitNest secondary text",
                color = colors.secondaryText,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                color = colors.primaryAction,
            ) {
                Text(
                    text = "Primary action",
                    color = colors.onPrimaryAction,
                    modifier = Modifier.padding(16.dp),
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
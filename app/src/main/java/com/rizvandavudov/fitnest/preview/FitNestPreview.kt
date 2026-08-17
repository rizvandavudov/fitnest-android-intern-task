package com.rizvandavudov.fitnest.preview

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rizvandavudov.fitnest.core.designsystem.FitNestTheme
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.core.designsystem.fitNestTypography

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    name = "Light",
    group = "Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 0xFFF0F1F6,
)
annotation class FitNestLightPreview

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    name = "Dark",
    group = "Theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF030510,
)
annotation class FitNestDarkPreview

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    name = "Component Light",
    group = "Component",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 0xFFF0F1F6,
)
@Preview(
    name = "Component Dark",
    group = "Component",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF030510,
)
annotation class FitNestComponentPreviews

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    name = "Home Light 402x956",
    group = "Home",
    widthDp = 402,
    heightDp = 956,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 0xFFF0F1F6,
)
@Preview(
    name = "Home Dark 402x956",
    group = "Home",
    widthDp = 402,
    heightDp = 956,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF030510,
)
annotation class FitNestHomePreviews

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    name = "Profile Light 402x1076",
    group = "Profile",
    widthDp = 402,
    heightDp = 1076,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 0xFFF0F1F6,
)
@Preview(
    name = "Profile Dark 402x1076",
    group = "Profile",
    widthDp = 402,
    heightDp = 1076,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF030510,
)
annotation class FitNestProfilePreviews

@Composable
fun FitNestPreview(
    content: @Composable () -> Unit,
) {
    FitNestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.fitNestColors.screenBackground,
        ) {
            content()
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun FitNestPreviewPreview() {
    FitNestPreview {
        Text(
            text = "FitNest Preview",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.fitNestTypography.sectionTitle,
            color = MaterialTheme.fitNestColors.primaryText,
        )
    }
}
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
@Preview(
    name = "Compact 360x800",
    group = "Responsive",
    widthDp = 360,
    heightDp = 800,
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 0xFFF0F1F6,
)
@Preview(
    name = "Reference 402x956",
    group = "Responsive",
    widthDp = 402,
    heightDp = 956,
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 0xFFF0F1F6,
)
@Preview(
    name = "Wide 412x915",
    group = "Responsive",
    widthDp = 412,
    heightDp = 915,
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 0xFFF0F1F6,
)
@Preview(
    name = "Compact Font 1.3",
    group = "Responsive",
    widthDp = 360,
    heightDp = 800,
    fontScale = 1.3f,
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    backgroundColor = 0xFFF0F1F6,
)
@Preview(
    name = "Wide Dark 412x915",
    group = "Responsive",
    widthDp = 412,
    heightDp = 915,
    fontScale = 1.15f,
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    backgroundColor = 0xFF030510,
)
annotation class FitNestResponsivePreviews
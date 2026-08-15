package com.rizvandavudov.fitnest.core.designsystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rizvandavudov.fitnest.R

/*
 * Figma SF Pro və SF Compact Rounded istifadə edir.
 * Bu fontlar Android standart fontu olmadığı üçün uyğun Android sistem
 * sans-serif fontu fallback kimi istifadə edilir.
 */
val FitNestSansFontFamily = FontFamily.SansSerif

val PoppinsFontFamily = FontFamily(
    Font(
        resId = R.font.poppins_regular,
        weight = FontWeight.Normal,
    ),
)

private fun fitNestTextStyle(
    fontFamily: FontFamily = FitNestSansFontFamily,
    fontWeight: FontWeight,
    fontSize: Int,
    lineHeight: Int,
): TextStyle {
    return TextStyle(
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize.sp,
        lineHeight = lineHeight.sp,
        letterSpacing = 0.sp,
    )
}

@Immutable
data class FitNestTypography(
    val screenTitle: TextStyle,
    val greeting: TextStyle,
    val marketTitle: TextStyle,
    val sectionTitle: TextStyle,
    val categoryLabel: TextStyle,
    val fieldLabel: TextStyle,
    val fieldValue: TextStyle,
    val bodyLarge: TextStyle,
    val gymTitle: TextStyle,
    val gymDistance: TextStyle,
    val sectionLink: TextStyle,
    val bodySmall: TextStyle,
    val navigationLabel: TextStyle,
    val statusLabel: TextStyle,
    val buttonLabel: TextStyle,
)

internal val DefaultFitNestTypography = FitNestTypography(
    screenTitle = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 18,
        lineHeight = 28,
    ),
    greeting = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 18,
        lineHeight = 28,
    ),
    marketTitle = fitNestTextStyle(
        fontFamily = PoppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18,
        lineHeight = 28,
    ),
    sectionTitle = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 18,
        lineHeight = 28,
    ),
    categoryLabel = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16,
        lineHeight = 24,
    ),
    fieldLabel = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16,
        lineHeight = 24,
    ),
    fieldValue = fitNestTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16,
        lineHeight = 24,
    ),
    bodyLarge = fitNestTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16,
        lineHeight = 24,
    ),
    gymTitle = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14,
        lineHeight = 20,
    ),
    gymDistance = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14,
        lineHeight = 20,
    ),
    sectionLink = fitNestTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14,
        lineHeight = 18,
    ),
    bodySmall = fitNestTextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12,
        lineHeight = 16,
    ),
    navigationLabel = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12,
        lineHeight = 18,
    ),
    statusLabel = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12,
        lineHeight = 18,
    ),
    buttonLabel = fitNestTextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 18,
        lineHeight = 28,
    ),
)

internal val LocalFitNestTypography = staticCompositionLocalOf {
    DefaultFitNestTypography
}

internal val MaterialTypography = Typography(
    headlineSmall = DefaultFitNestTypography.screenTitle,
    titleLarge = DefaultFitNestTypography.sectionTitle,
    titleMedium = DefaultFitNestTypography.fieldLabel,
    bodyLarge = DefaultFitNestTypography.bodyLarge,
    bodyMedium = DefaultFitNestTypography.gymTitle,
    bodySmall = DefaultFitNestTypography.bodySmall,
    labelLarge = DefaultFitNestTypography.buttonLabel,
    labelMedium = DefaultFitNestTypography.navigationLabel,
    labelSmall = DefaultFitNestTypography.statusLabel,
)
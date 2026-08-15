package com.rizvandavudov.fitnest.core.designsystem

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color




private val SoftBlue100 = Color(0xFFF0F1F6)
private val SoftBlue1100 = Color(0xFF030510)

private val White = Color(0xFFFFFFFF)
private val Neutral50 = Color(0xFFFFFFFF)
private val Neutral200 = Color(0xFFF0F0F1)
private val Neutral300 = Color(0xFFECECED)
private val Neutral500 = Color(0xFF94979C)
private val Neutral600 = Color(0xFF85888E)
private val Neutral700 = Color(0xFF919199)
private val Neutral800 = Color(0xFF373A41)
private val Neutral850 = Color(0xFF616166)
private val Neutral900 = Color(0xFF22262F)
private val Neutral950 = Color(0xFF13161B)
private val Neutral1000 = Color(0xFF0C0E12)

private val Primary500 = Color(0xFF00E1FF)
private val Primary600 = Color(0xFF00CDE8)
private val Primary700B = Color(0xFF00B4CC)

private val SuccessLight = Color(0xFF0DAC25)
private val SuccessDark = Color(0xFF02BA1D)
private val SuccessContainerLight = Color(0x1F0DAC25)
private val SuccessContainerDark = Color(0xFF1B4649)

private val ErrorLight = Color(0xFFCA1818)
private val ErrorDark = Color(0xFFC6585A)

internal val LightColorScheme = lightColorScheme(
    primary = Primary700B,
    onPrimary = White,
    background = SoftBlue100,
    onBackground = Neutral1000,
    surface = Neutral50,
    onSurface = Neutral1000,
    surfaceVariant = Neutral200,
    onSurfaceVariant = Neutral600,
    outline = Neutral300,
    error = ErrorLight,
    onError = White,
)

internal val DarkColorScheme = darkColorScheme(
    primary = Primary700B,
    onPrimary = White,
    background = SoftBlue1100,
    onBackground = White,
    surface = Neutral1000,
    onSurface = White,
    surfaceVariant = Neutral800,
    onSurfaceVariant = Neutral600,
    outline = Neutral600,
    error = ErrorDark,
    onError = White,
)

/**
 * FitNest dizaynında Material ColorScheme daxilində ayrıca qarşılığı olmayan
 * rəng rolları.
 */
@Immutable
data class FitNestColors(
    val screenBackground: Color,
    val surface: Color,
    val elevatedSurface: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val fieldSurface: Color,
    val fieldBorder: Color,
    val iconContainer: Color,
    val primaryAction: Color,
    val onPrimaryAction: Color,
    val linkAccent: Color,
    val activeNavigation: Color,
    val inactiveNavigation: Color,
    val success: Color,
    val successContainer: Color,
    val logoutError: Color,
    val divider: Color,
    val navigationSurface: Color,
    val navigationBorder: Color,
)

internal val LightFitNestColors = FitNestColors(
    screenBackground = SoftBlue100,
    surface = White,
    elevatedSurface = White,
    primaryText = Neutral1000,
    secondaryText = Neutral600,
    fieldSurface = White,
    fieldBorder = Neutral300,
    iconContainer = Neutral200,
    primaryAction = Primary700B,
    onPrimaryAction = White,
    linkAccent = Primary700B,
    activeNavigation = Neutral1000,
    inactiveNavigation = Neutral1000,
    success = SuccessLight,
    successContainer = SuccessContainerLight,
    logoutError = ErrorLight,
    divider = Neutral300,
    navigationSurface = Color(0x80FFFFFF),
    navigationBorder = Neutral300,
)

internal val DarkFitNestColors = FitNestColors(
    screenBackground = SoftBlue1100,
    surface = Neutral1000,
    elevatedSurface = Neutral950,
    primaryText = White,
    secondaryText = Neutral600,
    fieldSurface = Neutral1000,
    fieldBorder = Neutral600,
    iconContainer = Neutral800,
    primaryAction = Primary700B,
    onPrimaryAction = White,
    linkAccent = Primary500,
    activeNavigation = Primary600,
    inactiveNavigation = Neutral850,
    success = SuccessDark,
    successContainer = SuccessContainerDark,
    logoutError = ErrorDark,
    divider = Neutral900,
    navigationSurface = Color(0xFF030C10),
    navigationBorder = Neutral800,
)

internal val LocalFitNestColors = staticCompositionLocalOf {
    LightFitNestColors
}
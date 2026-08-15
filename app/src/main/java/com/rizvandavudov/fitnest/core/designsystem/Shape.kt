package com.rizvandavudov.fitnest.core.designsystem

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

object FitNestRadii {
    val radius8 = 8.dp
    val radius12 = 12.dp
    val radius16 = 16.dp
    val radius20 = 20.dp
    val radius26 = 26.dp
    val radius32 = 32.dp
    val radius36 = 36.dp
    val radius40 = 40.dp
    val radius50 = 50.dp
}

@Immutable
data class FitNestShapes(
    val image: Shape,
    val productImage: Shape,
    val card: Shape,
    val navigationBar: Shape,
    val field: Shape,
    val button: Shape,
    val avatar: Shape,
    val iconContainer: Shape,
    val circularContainer: Shape,
)

internal val DefaultFitNestShapes = FitNestShapes(
    image = RoundedCornerShape(FitNestRadii.radius8),
    productImage = RoundedCornerShape(FitNestRadii.radius12),
    card = RoundedCornerShape(FitNestRadii.radius16),
    navigationBar = RoundedCornerShape(
        topStart = FitNestRadii.radius20,
        topEnd = FitNestRadii.radius20,
    ),
    field = RoundedCornerShape(FitNestRadii.radius26),
    button = RoundedCornerShape(FitNestRadii.radius32),
    avatar = RoundedCornerShape(FitNestRadii.radius36),
    iconContainer = RoundedCornerShape(FitNestRadii.radius40),
    circularContainer = RoundedCornerShape(FitNestRadii.radius50),
)

internal val LocalFitNestShapes = staticCompositionLocalOf {
    DefaultFitNestShapes
}

internal val MaterialShapes = Shapes(
    extraSmall = RoundedCornerShape(FitNestRadii.radius8),
    small = RoundedCornerShape(FitNestRadii.radius12),
    medium = RoundedCornerShape(FitNestRadii.radius16),
    large = RoundedCornerShape(FitNestRadii.radius20),
    extraLarge = RoundedCornerShape(FitNestRadii.radius32),
)
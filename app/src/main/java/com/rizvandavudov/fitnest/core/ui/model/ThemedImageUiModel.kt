package com.rizvandavudov.fitnest.core.ui.model

import androidx.annotation.DrawableRes

data class ThemedImageUiModel(
    val lightUrl: String,
    val darkUrl: String = lightUrl,
    @param:DrawableRes
    val lightFallbackResId: Int,
    @param:DrawableRes
    val darkFallbackResId: Int = lightFallbackResId,
) {
    fun url(isDarkTheme: Boolean): String {
        return if (isDarkTheme) {
            darkUrl
        } else {
            lightUrl
        }
    }

    @DrawableRes
    fun fallbackResId(isDarkTheme: Boolean): Int {
        return if (isDarkTheme) {
            darkFallbackResId
        } else {
            lightFallbackResId
        }
    }
}
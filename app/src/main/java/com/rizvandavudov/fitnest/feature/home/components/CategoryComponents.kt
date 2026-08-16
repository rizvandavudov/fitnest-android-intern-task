package com.rizvandavudov.fitnest.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.core.designsystem.fitNestShapes
import com.rizvandavudov.fitnest.core.designsystem.fitNestTypography
import com.rizvandavudov.fitnest.core.ui.components.FitNestNetworkImage
import com.rizvandavudov.fitnest.feature.home.CategoryLightAppearance
import com.rizvandavudov.fitnest.feature.home.CategoryUiModel
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.PreviewData

@Composable
fun CategoryCard(
    model: CategoryUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val isDarkTheme = isSystemInDarkTheme()
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography
    val shapes = MaterialTheme.fitNestShapes

    val usesDarkOverlay = isDarkTheme ||
            model.lightAppearance == CategoryLightAppearance.DARK_OVERLAY

    val overlayColor = if (usesDarkOverlay) {
        colors.imageOverlayDark
    } else {
        colors.imageOverlayLight
    }

    val contentColor = if (usesDarkOverlay) {
        colors.onImageOverlayDark
    } else {
        colors.onImageOverlayLight
    }

    Box(
        modifier = modifier
            .size(FitNestDimens.categoryCardSize)
            .clip(shapes.image)
            .clearAndSetSemantics {
                contentDescription = model.title
                role = Role.Button
            }
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        FitNestNetworkImage(
            imageUrl = model.image.url(isDarkTheme),
            fallbackResId = model.image.fallbackResId(isDarkTheme),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(overlayColor),
        )

        Text(
            text = model.title,
            style = typography.categoryLabel,
            color = contentColor,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(FitNestDimens.smallSpacing),
        )
    }
}

@Composable
fun CategoryRow(
    categories: List<CategoryUiModel>,
    onCategoryClick: (CategoryUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(
            horizontal = FitNestDimens.screenHorizontalPadding,
        ),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(
            FitNestDimens.categoryCardSpacing,
        ),
    ) {
        items(
            items = categories,
            key = { category -> category.id },
        ) { category ->
            CategoryCard(
                model = category,
                onClick = {
                    onCategoryClick(category)
                },
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun CategoryCardPreview() {
    FitNestPreview {
        CategoryCard(
            model = PreviewData.homeUiState.categories.first(),
            onClick = {},
            modifier = Modifier.padding(FitNestDimens.screenHorizontalPadding),
        )
    }
}

@FitNestComponentPreviews
@Composable
private fun CategoryRowPreview() {
    FitNestPreview {
        CategoryRow(
            categories = PreviewData.homeUiState.categories,
            onCategoryClick = {},
        )
    }
}
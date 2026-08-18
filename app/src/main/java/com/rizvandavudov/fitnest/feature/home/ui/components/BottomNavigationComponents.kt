package com.rizvandavudov.fitnest.feature.home.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.feature.home.BottomNavigationDestination
import com.rizvandavudov.fitnest.feature.home.BottomNavigationItemUiModel
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.PreviewData

@DrawableRes
private fun BottomNavigationDestination.iconResId(): Int {
    return when (this) {
        BottomNavigationDestination.HOME ->
            R.drawable.ic_nav_home

        BottomNavigationDestination.SEARCH ->
            R.drawable.ic_nav_search

        BottomNavigationDestination.QR ->
            R.drawable.ic_nav_qr

        BottomNavigationDestination.SUBSCRIPTION ->
            R.drawable.ic_nav_subscription

        BottomNavigationDestination.MORE ->
            R.drawable.ic_nav_more
    }
}

@Composable
fun BottomNavigationItem(
    item: BottomNavigationItemUiModel,
    isSelected: Boolean,
    itemContentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors

    val contentColor = if (isSelected) {
        colors.activeNavigation
    } else {
        colors.inactiveNavigation
    }

    val iconSize =
        if (
            item.destination ==
            BottomNavigationDestination.QR
        ) {
            FitNestDimens.homeBottomBarQrIconSize
        } else {
            FitNestDimens.homeBottomBarIconSize
        }

    val iconLabelSpacing =
        if (
            item.destination ==
            BottomNavigationDestination.QR
        ) {
            FitNestDimens.homeBottomBarQrLabelSpacing
        } else {
            FitNestDimens.homeBottomBarIconLabelSpacing
        }

    Column(
        modifier = modifier
            .height(
                FitNestDimens.homeBottomBarItemHeight,
            )
            .clickable(
                enabled = item.isEnabled,
                onClick = onClick,
            )
            .semantics {
                contentDescription =
                    itemContentDescription
                role = Role.Button
                selected = isSelected

                if (!item.isEnabled) {
                    disabled()
                }
            },
        horizontalAlignment =
            Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = iconLabelSpacing,
            alignment = Alignment.CenterVertically,
        ),
    ) {
        Icon(
            painter = painterResource(
                item.destination.iconResId(),
            ),
            contentDescription = null,
            modifier = Modifier.size(iconSize),
            tint = contentColor,
        )

        Text(
            text = item.label,
            style = MaterialTheme.typography.labelSmall,
            color = contentColor,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
fun FitNestBottomBar(
    items: List<BottomNavigationItemUiModel>,
    selectedDestination: BottomNavigationDestination,
    itemContentDescription:
        (BottomNavigationItemUiModel) -> String,
    onItemClick: (BottomNavigationItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors

    val navigationShape = RoundedCornerShape(
        topStart =
            FitNestDimens.homeBottomBarTopRadius,
        topEnd =
            FitNestDimens.homeBottomBarTopRadius,
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(navigationShape)
            .background(colors.navigationSurface)
            .drawBehind {
                drawLine(
                    color = colors.navigationBorder,
                    start = Offset.Zero,
                    end = Offset(
                        x = size.width,
                        y = 0f,
                    ),
                    strokeWidth =
                        FitNestDimens
                            .homeBottomBarBorderWidth
                            .toPx(),
                )
            },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    FitNestDimens.homeBottomBarHeight,
                )
                .padding(
                    horizontal =
                        FitNestDimens
                            .screenHorizontalPadding,
                    vertical =
                        FitNestDimens
                            .screenHorizontalPadding,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    item = item,
                    isSelected =
                        item.destination ==
                                selectedDestination,
                    itemContentDescription =
                        itemContentDescription(item),
                    onClick = {
                        onItemClick(item)
                    },
                    modifier = Modifier.weight(1f),
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsBottomHeight(
                    WindowInsets.navigationBars,
                ),
        )
    }
}

@FitNestComponentPreviews
@Composable
private fun BottomNavigationItemPreview() {
    FitNestPreview {
        BottomNavigationItem(
            item = PreviewData
                .homeUiState
                .bottomNavigationItems
                .first(),
            isSelected = true,
            itemContentDescription = "Əsas səhifə",
            onClick = {},
            modifier = Modifier.width(
                FitNestDimens.homeBottomBarItemWidth,
            ),
        )
    }
}

@FitNestComponentPreviews
@Composable
private fun FitNestBottomBarPreview() {
    FitNestPreview {
        FitNestBottomBar(
            items =
                PreviewData
                    .homeUiState
                    .bottomNavigationItems,
            selectedDestination =
                PreviewData
                    .homeUiState
                    .selectedNavigationItem,
            itemContentDescription = { item ->
                item.label
            },
            onItemClick = {},
        )
    }
}
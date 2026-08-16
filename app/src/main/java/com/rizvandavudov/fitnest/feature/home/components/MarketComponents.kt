package com.rizvandavudov.fitnest.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.core.ui.components.FitNestNetworkImage
import com.rizvandavudov.fitnest.feature.home.MarketImageSizeStyle
import com.rizvandavudov.fitnest.feature.home.MarketItemUiModel
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.PreviewData

@Composable
fun MarketCard(
    model: MarketItemUiModel,
    cardContentDescription: String,
    bookmarkContentDescription: String,
    actionContentDescription: String,
    onCardClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val isDarkTheme = isSystemInDarkTheme()

    val isFeaturedDarkItem =
        isDarkTheme &&
                model.imageSizeStyle == MarketImageSizeStyle.FEATURED

    val cardShape = RoundedCornerShape(
        if (isDarkTheme) {
            FitNestDimens.marketDarkCardRadius
        } else {
            FitNestDimens.marketLightCardRadius
        },
    )

    val imageShape = RoundedCornerShape(
        if (isFeaturedDarkItem) {
            FitNestDimens.marketFeaturedDarkImageRadius
        } else {
            FitNestDimens.marketLightImageRadius
        },
    )

    val imageWidth = if (isFeaturedDarkItem) {
        FitNestDimens.marketFeaturedDarkImageWidth
    } else {
        FitNestDimens.marketImageWidth
    }

    val imageHeight = if (isFeaturedDarkItem) {
        FitNestDimens.marketFeaturedDarkImageHeight
    } else {
        FitNestDimens.marketImageHeight
    }

    val actionButtonWidth = if (isFeaturedDarkItem) {
        FitNestDimens.marketFeaturedDarkButtonWidth
    } else {
        FitNestDimens.marketButtonWidth
    }

    Row(
        modifier = modifier
            .width(FitNestDimens.marketCardWidth)
            .height(FitNestDimens.marketCardHeight)
            .clip(cardShape)
            .background(colors.surface)
            .clickable(onClick = onCardClick)
            .semantics {
                contentDescription = cardContentDescription
                role = Role.Button
            }
            .padding(FitNestDimens.itemSpacing),
        horizontalArrangement = Arrangement.spacedBy(
            FitNestDimens.itemSpacing,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FitNestNetworkImage(
            imageUrl = model.image.url(isDarkTheme),
            fallbackResId = model.image.fallbackResId(isDarkTheme),
            contentDescription = null,
            modifier = Modifier
                .width(imageWidth)
                .height(imageHeight)
                .clip(imageShape),
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = model.storeName,
                    style = MaterialTheme.typography.titleMedium,
                    color = colors.primaryText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                )

                Box(
                    modifier = Modifier
                        .size(FitNestDimens.marketBookmarkTouchTarget)
                        .clickable(onClick = onBookmarkClick)
                        .semantics {
                            contentDescription =
                                bookmarkContentDescription
                            role = Role.Button
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(
                            R.drawable.ic_bookmark,
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(
                            FitNestDimens.marketBookmarkIconSize,
                        ),
                        tint = colors.primaryText,
                    )
                }
            }

            Text(
                text = model.address,
                style = MaterialTheme.typography.bodySmall,
                color = colors.secondaryText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .width(
                            FitNestDimens.marketDiscountBadgeWidth,
                        )
                        .height(FitNestDimens.marketButtonHeight)
                        .clip(MaterialTheme.shapes.extraLarge)
                        .background(colors.secondaryContainer),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = model.discountText,
                        style = MaterialTheme.typography.labelSmall,
                        color = colors.primaryText,
                        maxLines = 1,
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .width(actionButtonWidth)
                        .height(FitNestDimens.marketButtonHeight)
                        .clip(MaterialTheme.shapes.extraLarge)
                        .background(colors.primaryAction)
                        .clickable(onClick = onActionClick)
                        .semantics {
                            contentDescription =
                                actionContentDescription
                            role = Role.Button
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = model.actionText,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                        maxLines = 1,
                    )
                }
            }
        }
    }
}

@Composable
fun MarketSection(
    title: String,
    actionLabel: String,
    actionContentDescription: String,
    marketItems: List<MarketItemUiModel>,
    cardContentDescription: (MarketItemUiModel) -> String,
    bookmarkContentDescription: (MarketItemUiModel) -> String,
    marketActionContentDescription: (MarketItemUiModel) -> String,
    onSeeAllClick: () -> Unit,
    onMarketItemClick: (MarketItemUiModel) -> Unit,
    onBookmarkClick: (MarketItemUiModel) -> Unit,
    onMarketActionClick: (MarketItemUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        SectionHeader(
            title = title,
            actionLabel = actionLabel,
            actionContentDescription = actionContentDescription,
            onActionClick = onSeeAllClick,
            typography = SectionHeaderTypography.MARKET,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal =
                        FitNestDimens.screenHorizontalPadding,
                ),
        )

        Spacer(
            modifier = Modifier.height(
                FitNestDimens.homeSectionHeaderContentSpacing,
            ),
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = FitNestDimens.screenHorizontalPadding,
            ),
            horizontalArrangement = Arrangement.spacedBy(
                FitNestDimens.itemSpacing,
            ),
        ) {
            items(
                items = marketItems,
                key = { item -> item.id },
            ) { item ->
                MarketCard(
                    model = item,
                    cardContentDescription =
                        cardContentDescription(item),
                    bookmarkContentDescription =
                        bookmarkContentDescription(item),
                    actionContentDescription =
                        marketActionContentDescription(item),
                    onCardClick = {
                        onMarketItemClick(item)
                    },
                    onBookmarkClick = {
                        onBookmarkClick(item)
                    },
                    onActionClick = {
                        onMarketActionClick(item)
                    },
                )
            }
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun MarketCardPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier
                .background(
                    MaterialTheme.fitNestColors.screenBackground,
                )
                .padding(FitNestDimens.screenHorizontalPadding),
        ) {
            MarketCard(
                model = PreviewData.homeUiState.marketItems.first(),
                cardContentDescription =
                    "Vitamin House məhsul kartı",
                bookmarkContentDescription =
                    "Vitamin House yadda saxla",
                actionContentDescription =
                    "Vitamin House mağazasına keç",
                onCardClick = {},
                onBookmarkClick = {},
                onActionClick = {},
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun MarketSectionPreview() {
    FitNestPreview {
        MarketSection(
            title = "FitMarket",
            actionLabel = "Daha çox",
            actionContentDescription =
                "Daha çox FitMarket məhsuluna bax",
            marketItems = PreviewData.homeUiState.marketItems,
            cardContentDescription = { item ->
                "${item.storeName} məhsul kartı"
            },
            bookmarkContentDescription = { item ->
                "${item.storeName} yadda saxla"
            },
            marketActionContentDescription = { item ->
                "${item.storeName} mağazasına keç"
            },
            onSeeAllClick = {},
            onMarketItemClick = {},
            onBookmarkClick = {},
            onMarketActionClick = {},
            modifier = Modifier
                .background(
                    MaterialTheme.fitNestColors.screenBackground,
                )
                .padding(
                    vertical = FitNestDimens.itemSpacing,
                ),
        )
    }
}
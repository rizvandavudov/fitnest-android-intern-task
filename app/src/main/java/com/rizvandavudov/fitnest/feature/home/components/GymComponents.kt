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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import com.rizvandavudov.fitnest.core.designsystem.fitNestShapes
import com.rizvandavudov.fitnest.core.ui.components.FitNestNetworkImage
import com.rizvandavudov.fitnest.feature.home.GymLightOverlayStyle
import com.rizvandavudov.fitnest.feature.home.GymUiModel
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.PreviewData

@Composable
fun GymCard(
    model: GymUiModel,
    cardContentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val shapes = MaterialTheme.fitNestShapes
    val isDarkTheme = isSystemInDarkTheme()

    val imageOverlayColor = if (isDarkTheme) {
        colors.gymImageOverlayDark
    } else {
        when (model.lightOverlayStyle) {
            GymLightOverlayStyle.STRONG ->
                colors.gymImageOverlayStrong

            GymLightOverlayStyle.SOFT ->
                colors.gymImageOverlaySoft
        }
    }

    Column(
        modifier = modifier
            .width(FitNestDimens.gymCardWidth)
            .clickable(onClick = onClick)
            .semantics {
                contentDescription = cardContentDescription
                role = Role.Button
            },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(FitNestDimens.gymImageHeight)
                .clip(shapes.image),
        ) {
            FitNestNetworkImage(
                imageUrl = model.image.url(isDarkTheme),
                fallbackResId =
                    model.image.fallbackResId(isDarkTheme),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(imageOverlayColor),
            )

            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(
                        x = FitNestDimens.gymImageContentInset,
                        y = FitNestDimens.gymImageContentInset,
                    )
                    .height(FitNestDimens.gymRatingHeight)
                    .clip(CircleShape)
                    .background(colors.ratingContainer)
                    .padding(
                        horizontal = FitNestDimens.smallSpacing,
                    ),
                horizontalArrangement = Arrangement.spacedBy(
                    FitNestDimens.extraSmallSpacing,
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.ic_rating_star,
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        FitNestDimens.gymRatingIconSize,
                    ),
                    tint = colors.onRatingContainer,
                )

                Text(
                    text = model.rating,
                    style = MaterialTheme.typography.labelSmall,
                    color = colors.onRatingContainer,
                    maxLines = 1,
                )
            }

            model.badgeText?.let { badgeText ->
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(
                            x = -FitNestDimens.gymImageContentInset,
                            y = FitNestDimens.gymImageContentInset,
                        )
                        .width(FitNestDimens.gymBadgeWidth)
                        .height(FitNestDimens.gymBadgeHeight)
                        .clip(CircleShape)
                        .background(colors.badgeContainer),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = badgeText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = colors.onBadgeContainer,
                        maxLines = 1,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(FitNestDimens.itemSpacing))

        Column(
            verticalArrangement = Arrangement.spacedBy(
                FitNestDimens.gymMetaSpacing,
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    FitNestDimens.smallSpacing,
                ),
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.ic_location,
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        FitNestDimens.gymMetaIconSize,
                    ),
                    tint = colors.primaryText,
                )

                Text(
                    text = model.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.primaryText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    FitNestDimens.smallSpacing,
                ),
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.ic_direction,
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        FitNestDimens.gymMetaIconSize,
                    ),
                    tint = colors.primaryText,
                )

                Text(
                    text = model.distanceText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.primaryText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Composable
fun NearbyGymsSection(
    title: String,
    actionLabel: String,
    actionContentDescription: String,
    gyms: List<GymUiModel>,
    gymContentDescription: (GymUiModel) -> String,
    onSeeAllClick: () -> Unit,
    onGymClick: (GymUiModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        SectionHeader(
            title = title,
            actionLabel = actionLabel,
            actionContentDescription = actionContentDescription,
            onActionClick = onSeeAllClick,
            typography = SectionHeaderTypography.DEFAULT,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal =
                        FitNestDimens.screenHorizontalPadding,
                ),
        )

        Spacer(modifier = Modifier.height(FitNestDimens.itemSpacing))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = FitNestDimens.screenHorizontalPadding,
            ),
            horizontalArrangement = Arrangement.spacedBy(
                FitNestDimens.gymCardSpacing,
            ),
        ) {
            items(
                items = gyms,
                key = { gym -> gym.id },
            ) { gym ->
                GymCard(
                    model = gym,
                    cardContentDescription =
                        gymContentDescription(gym),
                    onClick = {
                        onGymClick(gym)
                    },
                )
            }
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun GymCardPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier
                .background(
                    MaterialTheme.fitNestColors.screenBackground,
                )
                .padding(FitNestDimens.screenHorizontalPadding),
        ) {
            GymCard(
                model = PreviewData.homeUiState.gyms.first(),
                cardContentDescription =
                    "Pulse Gym, 4.5 reytinq, sizdən 12.2 kilometr uzaqlıqda",
                onClick = {},
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun NearbyGymsSectionPreview() {
    FitNestPreview {
        NearbyGymsSection(
            title = "Yaxınlıqdakı zallar",
            actionLabel = "Daha çox",
            actionContentDescription =
                "Yaxınlıqdakı bütün zallara bax",
            gyms = PreviewData.homeUiState.gyms,
            gymContentDescription = { gym ->
                "${gym.name}, ${gym.rating} reytinq, " +
                        gym.distanceText
            },
            onSeeAllClick = {},
            onGymClick = {},
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
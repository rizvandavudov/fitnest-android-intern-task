package com.rizvandavudov.fitnest.feature.profile.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.core.designsystem.fitNestShapes
import com.rizvandavudov.fitnest.core.designsystem.fitNestTypography
import com.rizvandavudov.fitnest.feature.profile.ui.SubscriptionStatus
import com.rizvandavudov.fitnest.feature.profile.ui.SubscriptionUiModel
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.PreviewData

@Composable
fun ProfileIconContainer(
    @DrawableRes iconResId: Int,
    iconContentDescription: String,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors

    Box(
        modifier = modifier
            .size(FitNestDimens.profileFieldIconContainerSize)
            .clip(CircleShape)
            .background(colors.iconContainer),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(iconResId),
            contentDescription = iconContentDescription,
            modifier = Modifier.size(
                FitNestDimens.profileFieldIconSize,
            ),
            tint = colors.primaryText,
        )
    }
}

@Composable
fun ProfileField(
    label: String,
    value: String,
    @DrawableRes iconResId: Int,
    iconContentDescription: String,
    editContentDescription: String,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography
    val shapes = MaterialTheme.fitNestShapes

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(FitNestDimens.profileFieldGroupHeight),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(FitNestDimens.profileFieldLabelHeight)
                .padding(
                    horizontal =
                        FitNestDimens.profileFieldLabelHorizontalPadding,
                    vertical =
                        FitNestDimens.profileFieldLabelVerticalPadding,
                ),
            contentAlignment = Alignment.CenterStart,
        ) {
            Text(
                text = label,
                style = typography.fieldLabel,
                color = colors.fieldLabelText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Spacer(
            modifier = Modifier.height(
                FitNestDimens.profileFieldLabelToInputSpacing,
            ),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(FitNestDimens.profileFieldHeight)
                .clip(shapes.field)
                .background(colors.fieldSurface)
                .border(
                    width = FitNestDimens.thinBorder,
                    color = colors.fieldBorder,
                    shape = shapes.field,
                )
                .padding(
                    start =
                        FitNestDimens.profileFieldContentStartPadding,
                    end =
                        FitNestDimens.profileFieldContentEndPadding,
                )
                .semantics {
                    contentDescription = "$label: $value"
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProfileIconContainer(
                iconResId = iconResId,
                iconContentDescription =
                    iconContentDescription,
            )

            Spacer(
                modifier = Modifier.width(
                    FitNestDimens.profileFieldIconValueSpacing,
                ),
            )

            Text(
                text = value,
                modifier = Modifier.weight(1f),
                style = typography.fieldValue,
                color = colors.primaryText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Box(
                modifier = Modifier
                    .offset(
                        x = FitNestDimens
                            .profileFieldEditTouchOffsetX,
                    )
                    .size(FitNestDimens.minimumTouchTarget)
                    .clip(CircleShape)
                    .clickable(
                        role = Role.Button,
                        onClick = onEditClick,
                    )
                    .semantics {
                        contentDescription =
                            editContentDescription
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(
                        R.drawable.ic_profile_edit,
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        FitNestDimens.profileEditIconSize,
                    ),
                    tint = colors.editIcon,
                )
            }
        }
    }
}

@Composable
fun ActiveStatusChip(
    label: String,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography

    Row(
        modifier = modifier
            .width(FitNestDimens.profileStatusChipWidth)
            .height(FitNestDimens.profileStatusChipHeight)
            .clip(CircleShape)
            .background(colors.successContainer)
            .padding(
                horizontal =
                    FitNestDimens.profileStatusHorizontalPadding,
                vertical =
                    FitNestDimens.profileStatusVerticalPadding,
            )
            .semantics {
                contentDescription = label
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(FitNestDimens.profileStatusDotSize)
                .clip(CircleShape)
                .background(colors.success),
        )

        Spacer(
            modifier = Modifier.width(
                FitNestDimens.profileStatusContentSpacing,
            ),
        )

        Text(
            text = label,
            style = typography.statusLabel,
            color = colors.success,
            maxLines = 1,
            overflow = TextOverflow.Clip,
        )
    }
}

@Composable
fun SubscriptionField(
    label: String,
    subscription: SubscriptionUiModel,
    iconContentDescription: String,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography
    val shapes = MaterialTheme.fitNestShapes

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(FitNestDimens.profileFieldGroupHeight),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(FitNestDimens.profileFieldLabelHeight)
                .padding(
                    horizontal =
                        FitNestDimens.profileFieldLabelHorizontalPadding,
                    vertical =
                        FitNestDimens.profileFieldLabelVerticalPadding,
                ),
            contentAlignment = Alignment.CenterStart,
        ) {
            Text(
                text = label,
                style = typography.fieldLabel,
                color = colors.fieldLabelText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Spacer(
            modifier = Modifier.height(
                FitNestDimens.profileFieldLabelToInputSpacing,
            ),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(FitNestDimens.profileFieldHeight)
                .clip(shapes.field)
                .background(colors.fieldSurface)
                .border(
                    width = FitNestDimens.thinBorder,
                    color = colors.fieldBorder,
                    shape = shapes.field,
                )
                .padding(
                    start =
                        FitNestDimens.profileFieldContentStartPadding,
                    end =
                        FitNestDimens.profileFieldContentEndPadding,
                )
                .semantics {
                    contentDescription =
                        "$label: ${subscription.title}, " +
                                subscription.statusLabel
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProfileIconContainer(
                iconResId = R.drawable.ic_profile_plan,
                iconContentDescription =
                    iconContentDescription,
            )

            Spacer(
                modifier = Modifier.width(
                    FitNestDimens.profileFieldIconValueSpacing,
                ),
            )

            Text(
                text = subscription.title,
                modifier = Modifier.weight(1f),
                style = typography.fieldValue,
                color = colors.primaryText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            if (
                subscription.status ==
                SubscriptionStatus.ACTIVE
            ) {
                ActiveStatusChip(
                    label = subscription.statusLabel,
                )
            } else {
                Text(
                    text = subscription.statusLabel,
                    style = typography.statusLabel,
                    color = colors.secondaryText,
                    maxLines = 1,
                )
            }
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun ProfileIconContainerPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ProfileIconContainer(
                iconResId = R.drawable.ic_profile_user,
                iconContentDescription = "İstifadəçi",
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun ProfileFieldPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            ProfileField(
                label = "Ad",
                value = PreviewData.profileUiState.firstName,
                iconResId = R.drawable.ic_profile_user,
                iconContentDescription = "İstifadəçi",
                editContentDescription = "Adı redaktə et",
                onEditClick = {},
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun ActiveStatusChipPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ActiveStatusChip(
                label = "Aktiv",
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun SubscriptionFieldPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            SubscriptionField(
                label = "Abunəlik",
                subscription =
                    PreviewData.profileUiState.subscription,
                iconContentDescription = "Abunəlik planı",
            )
        }
    }
}
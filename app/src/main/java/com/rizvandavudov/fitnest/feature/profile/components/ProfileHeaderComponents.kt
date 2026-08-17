package com.rizvandavudov.fitnest.feature.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.core.designsystem.fitNestTypography
import com.rizvandavudov.fitnest.core.ui.components.FitNestNetworkImage
import com.rizvandavudov.fitnest.core.ui.model.ThemedImageUiModel
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.PreviewData

@Composable
fun ProfileTopBar(
    title: String,
    backContentDescription: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(FitNestDimens.profileTopBarHeight),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            style = typography.screenTitle,
            color = colors.primaryText,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(
                    x = FitNestDimens.profileTopBarHorizontalTouchPadding,
                )
                .size(FitNestDimens.minimumTouchTarget)
                .clip(CircleShape)
                .clickable(
                    role = Role.Button,
                    onClick = onBackClick,
                )
                .semantics {
                    contentDescription = backContentDescription
                },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(
                    R.drawable.ic_profile_back,
                ),
                contentDescription = null,
                modifier = Modifier.size(
                    FitNestDimens.profileTopBarIconSize,
                ),
                tint = colors.primaryText,
            )
        }
    }
}

@Composable
fun ProfileAvatar(
    avatar: ThemedImageUiModel,
    userId: String,
    avatarContentDescription: String,
    editContentDescription: String,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography
    val isDarkTheme = isSystemInDarkTheme()

    Column(
        modifier = modifier.width(
            FitNestDimens.profileAvatarFrameWidth,
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .width(FitNestDimens.profileAvatarFrameWidth)
                .height(
                    FitNestDimens.profileAvatarImageAreaHeight,
                ),
        ) {
            FitNestNetworkImage(
                imageUrl = avatar.url(isDarkTheme),
                fallbackResId = avatar.fallbackResId(
                    isDarkTheme,
                ),
                contentDescription = avatarContentDescription,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(FitNestDimens.profileAvatarSize)
                    .clip(CircleShape)
                    .border(
                        width = FitNestDimens.thinBorder,
                        color = colors.avatarBorder,
                        shape = CircleShape,
                    ),
                contentScale = ContentScale.Crop,
            )

            Box(
                modifier = Modifier
                    .offset(
                        x = FitNestDimens.profileAvatarEditTouchOffsetX,
                        y = FitNestDimens.profileAvatarEditTouchOffsetY,
                    )
                    .size(FitNestDimens.minimumTouchTarget)
                    .clip(CircleShape)
                    .clickable(
                        role = Role.Button,
                        onClick = onEditClick,
                    )
                    .semantics {
                        contentDescription = editContentDescription
                    },
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(
                            FitNestDimens.profileAvatarEditSize,
                        )
                        .clip(CircleShape)
                        .background(
                            colors.avatarEditContainer,
                        ),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(
                            R.drawable.ic_profile_avatar_edit,
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(
                            FitNestDimens.profileAvatarEditIconSize,
                        ),
                        tint = colors.primaryAction,
                    )
                }
            }
        }

        Text(
            text = "ID: $userId",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = FitNestDimens.profileAvatarIdSpacing,
                ),
            style = typography.bodyLarge,
            color = colors.profileIdText,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@FitNestComponentPreviews
@Composable
private fun ProfileTopBarPreview() {
    FitNestPreview {
        ProfileTopBar(
            title = "Profil",
            backContentDescription = "Geri qayıt",
            onBackClick = {},
        )
    }
}

@FitNestComponentPreviews
@Composable
private fun ProfileAvatarPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            ProfileAvatar(
                avatar = PreviewData.profileUiState.avatar,
                userId = PreviewData.profileUiState.userId,
                avatarContentDescription = "İstifadəçinin profil şəkli",
                editContentDescription = "Profil şəklini dəyiş",
                onEditClick = {},
            )
        }
    }
}
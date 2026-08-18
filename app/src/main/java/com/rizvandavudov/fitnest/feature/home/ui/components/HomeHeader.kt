package com.rizvandavudov.fitnest.feature.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.core.designsystem.fitNestTypography
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview

@Composable
fun HomeHeader(
    initials: String,
    greeting: String,
    avatarContentDescription: String,
    notificationContentDescription: String,
    onAvatarClick: () -> Unit,
    onNotificationClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(FitNestDimens.headerAvatarSize)
                .clip(CircleShape)
                .background(colors.surface)
                .clearAndSetSemantics {
                    contentDescription = avatarContentDescription
                    role = Role.Button
                }
                .clickable(onClick = onAvatarClick),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = initials,
                style = typography.bodyLarge,
                color = colors.primaryText,
                maxLines = 1,
            )
        }

        Spacer(
            modifier = Modifier.width(
                FitNestDimens.homeHeaderGreetingSpacing,
            ),
        )

        Text(
            text = greeting,
            style = typography.greeting,
            color = colors.primaryText,
            maxLines = 1,
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .size(FitNestDimens.notificationContainerSize)
                .clip(CircleShape)
                .background(colors.surface)
                .clearAndSetSemantics {
                    contentDescription = notificationContentDescription
                    role = Role.Button
                }
                .clickable(onClick = onNotificationClick),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_notification),
                contentDescription = null,
                modifier = Modifier.size(
                    FitNestDimens.notificationIconSize,
                ),
                tint = colors.primaryText,
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun HomeHeaderPreview() {
    FitNestPreview {
        HomeHeader(
            initials = "AS",
            greeting = "Salam, Nigar!",
            avatarContentDescription = "Profilə keç",
            notificationContentDescription = "Bildirişlər",
            onAvatarClick = {},
            onNotificationClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = FitNestDimens.screenHorizontalPadding,
                    vertical = FitNestDimens.itemSpacing,
                ),
        )
    }
}
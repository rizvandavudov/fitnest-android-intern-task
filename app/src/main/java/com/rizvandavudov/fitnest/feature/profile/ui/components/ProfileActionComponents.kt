package com.rizvandavudov.fitnest.feature.profile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview

@Composable
fun LogoutRow(
    title: String,
    description: String,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(FitNestDimens.profileLogoutRowHeight)
            .clickable(
                role = Role.Button,
                onClick = onClick,
            )
            .semantics(
                mergeDescendants = true,
            ) {
                this.contentDescription =
                    contentDescription
            }
            .padding(
                vertical =
                    FitNestDimens.profileLogoutVerticalPadding,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(
                    FitNestDimens
                        .profileLogoutIconContainerSize,
                )
                .clip(CircleShape)
                .background(colors.iconContainer),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(
                    R.drawable.ic_profile_logout,
                ),
                contentDescription = null,
                modifier = Modifier.size(
                    FitNestDimens.profileLogoutIconSize,
                ),
                tint = colors.logoutError,
            )
        }

        Spacer(
            modifier = Modifier.width(
                FitNestDimens.profileLogoutContentSpacing,
            ),
        )

        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = title,
                style = typography.fieldLabel,
                color = colors.logoutTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(
                modifier = Modifier.height(
                    FitNestDimens.profileLogoutTextSpacing,
                ),
            )

            Text(
                text = description,
                style = typography.bodySmall,
                color = colors.secondaryText,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }

        Icon(
            painter = painterResource(
                R.drawable.ic_profile_chevron_right,
            ),
            contentDescription = null,
            modifier = Modifier.size(
                FitNestDimens.profileChevronSize,
            ),
            tint = colors.trailingIcon,
        )
    }
}

@Composable
fun SaveButton(
    text: String,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors
    val typography = MaterialTheme.fitNestTypography
    val shapes = MaterialTheme.fitNestShapes

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(FitNestDimens.profileButtonHeight)
            .clip(shapes.button)
            .background(colors.primaryAction)
            .clickable(
                role = Role.Button,
                onClick = onClick,
            )
            .semantics {
                this.contentDescription =
                    contentDescription
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = typography.buttonLabel,
            color = colors.onPrimaryAction,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@FitNestComponentPreviews
@Composable
private fun LogoutRowPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            LogoutRow(
                title = "Çıxış",
                description = "Hesabdan çıxış edin",
                contentDescription =
                    "Hesabdan çıxış et",
                onClick = {},
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun SaveButtonPreview() {
    FitNestPreview {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center,
        ) {
            SaveButton(
                text = "Yadda saxla",
                contentDescription =
                    "Profil məlumatlarını yadda saxla",
                onClick = {},
            )
        }
    }
}
package com.rizvandavudov.fitnest.feature.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.text.TextStyle
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.core.designsystem.fitNestTypography
import com.rizvandavudov.fitnest.preview.FitNestComponentPreviews
import com.rizvandavudov.fitnest.preview.FitNestPreview

enum class SectionHeaderTypography {
    DEFAULT, MARKET,
}

@Composable
fun SectionHeader(
    title: String,
    actionLabel: String,
    actionContentDescription: String,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier,
    typography: SectionHeaderTypography = SectionHeaderTypography.DEFAULT,
) {
    val colors = MaterialTheme.fitNestColors
    val fitNestTypography = MaterialTheme.fitNestTypography

    val titleStyle: TextStyle = when (typography) {
        SectionHeaderTypography.DEFAULT -> fitNestTypography.sectionTitle

        SectionHeaderTypography.MARKET -> fitNestTypography.marketTitle
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = titleStyle,
            color = colors.primaryText,
            maxLines = 1,
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .clearAndSetSemantics {
                    contentDescription = actionContentDescription
                    role = Role.Button
                }
                .clickable(onClick = onActionClick),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = actionLabel,
                style = fitNestTypography.sectionLink,
                color = colors.linkAccent,
                maxLines = 1,
            )

            Spacer(
                modifier = Modifier.width(FitNestDimens.microSpacing),
            )

            Icon(
                painter = painterResource(
                    R.drawable.ic_arrow_right_small,
                ),
                contentDescription = null,
                modifier = Modifier.size(FitNestDimens.iconExtraSmall),
                tint = colors.linkAccent,
            )
        }
    }
}

@FitNestComponentPreviews
@Composable
private fun SectionHeaderPreview() {
    FitNestPreview {
        SectionHeader(
            title = "FitMarket",
            actionLabel = "Daha çox",
            actionContentDescription = "Daha çox məhsula bax",
            onActionClick = {},
            modifier = Modifier.padding(
                horizontal = FitNestDimens.screenHorizontalPadding,
                vertical = FitNestDimens.itemSpacing,
            ),
            typography = SectionHeaderTypography.MARKET,
        )
    }
}
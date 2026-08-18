package com.rizvandavudov.fitnest.feature.profile

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.feature.profile.ui.components.LogoutRow
import com.rizvandavudov.fitnest.feature.profile.ui.components.ProfileAvatar
import com.rizvandavudov.fitnest.feature.profile.ui.components.ProfileField
import com.rizvandavudov.fitnest.feature.profile.ui.components.ProfileTopBar
import com.rizvandavudov.fitnest.feature.profile.ui.components.SaveButton
import com.rizvandavudov.fitnest.feature.profile.ui.components.SubscriptionField
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.FitNestProfilePreviews
import com.rizvandavudov.fitnest.preview.FitNestResponsivePreviews

@Composable
fun ProfileScreen(
    state: ProfileUiState,
    onBackClick: () -> Unit,
    onAvatarEditClick: () -> Unit,
    onEditFieldClick: (ProfileField) -> Unit,
    onLogoutClick: () -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.fitNestColors

    val texts = state.texts

    BackHandler(
        enabled = true,
        onBack = onBackClick,
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colors.screenBackground,
        contentWindowInsets = WindowInsets(
            left = 0,
            top = 0,
            right = 0,
            bottom = 0,
        ),
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.screenBackground)
                    .navigationBarsPadding()
                    .padding(
                        start =
                            FitNestDimens.screenHorizontalPadding,
                        end =
                            FitNestDimens.screenHorizontalPadding,
                        top =
                            FitNestDimens.profileBottomBarSpacing,
                        bottom =
                            FitNestDimens.profileBottomBarSpacing,
                    ),
            ) {
                SaveButton(
                    text = texts.saveButtonText,
                    contentDescription =
                        texts.saveContentDescription,
                    onClick = onSaveClick,
                )
            }
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom =
                        innerPadding.calculateBottomPadding(),
                ),
            contentPadding = PaddingValues(
                bottom = FitNestDimens.contentSpacing,
            ),
        ) {
            item(key = "profile_top_bar") {
                ProfileTopBar(
                    title = texts.title,
                    backContentDescription =
                        texts.backContentDescription,
                    onBackClick = onBackClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding(),
                )
            }

            item(key = "top_bar_avatar_spacing") {
                Spacer(
                    modifier = Modifier.height(
                        FitNestDimens
                            .profileTopBarToAvatarSpacing,
                    ),
                )
            }

            item(key = "profile_avatar") {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    ProfileAvatar(
                        avatar = state.avatar,
                        userId = state.userId,
                        avatarContentDescription =
                            texts.avatarContentDescription,
                        editContentDescription =
                            texts.avatarEditContentDescription,
                        onEditClick = onAvatarEditClick,
                    )
                }
            }

            item(key = "avatar_fields_spacing") {
                Spacer(
                    modifier = Modifier.height(
                        FitNestDimens
                            .profileAvatarToFieldsSpacing,
                    ),
                )
            }

            item(key = "profile_fields") {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal =
                                FitNestDimens
                                    .screenHorizontalPadding,
                        ),
                    verticalArrangement = Arrangement.spacedBy(
                        FitNestDimens.profileFieldSpacing,
                    ),
                ) {
                    ProfileField(
                        label = texts.firstNameLabel,
                        value = state.firstName,
                        iconResId =
                            R.drawable.ic_profile_user,
                        iconContentDescription =
                            texts.userIconContentDescription,
                        editContentDescription =
                            texts.editFirstNameContentDescription,
                        onEditClick = {
                            onEditFieldClick(
                                ProfileField.FIRST_NAME,
                            )
                        },
                    )

                    ProfileField(
                        label = texts.lastNameLabel,
                        value = state.lastName,
                        iconResId =
                            R.drawable.ic_profile_user,
                        iconContentDescription =
                            texts.userIconContentDescription,
                        editContentDescription =
                            texts.editLastNameContentDescription,
                        onEditClick = {
                            onEditFieldClick(
                                ProfileField.LAST_NAME,
                            )
                        },
                    )

                    ProfileField(
                        label = texts.phoneLabel,
                        value = state.phoneNumber,
                        iconResId =
                            R.drawable.ic_profile_phone,
                        iconContentDescription =
                            texts.phoneIconContentDescription,
                        editContentDescription =
                            texts.editPhoneContentDescription,
                        onEditClick = {
                            onEditFieldClick(
                                ProfileField.PHONE_NUMBER,
                            )
                        },
                    )

                    ProfileField(
                        label = texts.emailLabel,
                        value = state.email,
                        iconResId =
                            R.drawable.ic_profile_email,
                        iconContentDescription =
                            texts.emailIconContentDescription,
                        editContentDescription =
                            texts.editEmailContentDescription,
                        onEditClick = {
                            onEditFieldClick(
                                ProfileField.EMAIL,
                            )
                        },
                    )

                    SubscriptionField(
                        label = texts.subscriptionLabel,
                        subscription = state.subscription,
                        iconContentDescription =
                            texts.subscriptionIconContentDescription,
                    )
                }
            }

            item(key = "fields_divider_spacing") {
                Spacer(
                    modifier = Modifier.height(
                        FitNestDimens.profileSectionSpacing,
                    ),
                )
            }

            item(key = "profile_divider") {
                HorizontalDivider(
                    modifier = Modifier.padding(
                        horizontal =
                            FitNestDimens
                                .screenHorizontalPadding,
                    ),
                    thickness = FitNestDimens.thinBorder,
                    color = colors.divider,
                )
            }

            item(key = "divider_logout_spacing") {
                Spacer(
                    modifier = Modifier.height(
                        FitNestDimens.profileSectionSpacing,
                    ),
                )
            }

            item(key = "profile_logout") {
                LogoutRow(
                    title = texts.logoutTitle,
                    description = texts.logoutDescription,
                    contentDescription =
                        texts.logoutContentDescription,
                    onClick = onLogoutClick,
                    modifier = Modifier.padding(
                        horizontal =
                            FitNestDimens
                                .screenHorizontalPadding,
                    ),
                )
            }
        }
    }
}

@FitNestProfilePreviews
@Composable
private fun ProfileScreenPreview() {
    FitNestPreview {
        ProfileScreen(
            state = ProfileSampleData.state,
            onBackClick = {},
            onAvatarEditClick = {},
            onEditFieldClick = {},
            onLogoutClick = {},
            onSaveClick = {},
        )
    }
}

@FitNestResponsivePreviews
@Composable
private fun ProfileResponsivePreview() {
    FitNestPreview {
        ProfileScreen(
            state = ProfileSampleData.state,
            onBackClick = {},
            onAvatarEditClick = {},
            onEditFieldClick = {},
            onLogoutClick = {},
            onSaveClick = {},
        )
    }
}
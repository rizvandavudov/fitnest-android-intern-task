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
import androidx.compose.ui.res.stringResource
import com.rizvandavudov.fitnest.R
import com.rizvandavudov.fitnest.core.designsystem.FitNestDimens
import com.rizvandavudov.fitnest.core.designsystem.fitNestColors
import com.rizvandavudov.fitnest.feature.profile.components.LogoutRow
import com.rizvandavudov.fitnest.feature.profile.components.ProfileAvatar
import com.rizvandavudov.fitnest.feature.profile.components.ProfileField
import com.rizvandavudov.fitnest.feature.profile.components.ProfileTopBar
import com.rizvandavudov.fitnest.feature.profile.components.SaveButton
import com.rizvandavudov.fitnest.feature.profile.components.SubscriptionField
import com.rizvandavudov.fitnest.preview.FitNestPreview
import com.rizvandavudov.fitnest.preview.FitNestProfilePreviews
import com.rizvandavudov.fitnest.preview.PreviewData

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

    val title = stringResource(R.string.profile_title)
    val backContentDescription = stringResource(
        R.string.profile_back_content_description,
    )

    val avatarContentDescription = stringResource(
        R.string.profile_avatar_content_description,
    )
    val avatarEditContentDescription = stringResource(
        R.string.profile_avatar_edit_content_description,
    )

    val firstNameLabel = stringResource(
        R.string.profile_first_name_label,
    )
    val lastNameLabel = stringResource(
        R.string.profile_last_name_label,
    )
    val phoneLabel = stringResource(
        R.string.profile_phone_label,
    )
    val emailLabel = stringResource(
        R.string.profile_email_label,
    )
    val subscriptionLabel = stringResource(
        R.string.profile_subscription_label,
    )

    val userIconContentDescription = stringResource(
        R.string.profile_user_icon_content_description,
    )
    val phoneIconContentDescription = stringResource(
        R.string.profile_phone_icon_content_description,
    )
    val emailIconContentDescription = stringResource(
        R.string.profile_email_icon_content_description,
    )
    val subscriptionIconContentDescription = stringResource(
        R.string.profile_subscription_icon_content_description,
    )

    val editFirstNameContentDescription = stringResource(
        R.string.profile_edit_first_name_content_description,
    )
    val editLastNameContentDescription = stringResource(
        R.string.profile_edit_last_name_content_description,
    )
    val editPhoneContentDescription = stringResource(
        R.string.profile_edit_phone_content_description,
    )
    val editEmailContentDescription = stringResource(
        R.string.profile_edit_email_content_description,
    )

    val logoutTitle = stringResource(
        R.string.profile_logout_title,
    )
    val logoutDescription = stringResource(
        R.string.profile_logout_description,
    )
    val logoutContentDescription = stringResource(
        R.string.profile_logout_content_description,
    )

    val saveButtonText = stringResource(
        R.string.profile_save_button,
    )
    val saveContentDescription = stringResource(
        R.string.profile_save_content_description,
    )

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
                    text = saveButtonText,
                    contentDescription =
                        saveContentDescription,
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
                    title = title,
                    backContentDescription =
                        backContentDescription,
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
                            avatarContentDescription,
                        editContentDescription =
                            avatarEditContentDescription,
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
                        label = firstNameLabel,
                        value = state.firstName,
                        iconResId =
                            R.drawable.ic_profile_user,
                        iconContentDescription =
                            userIconContentDescription,
                        editContentDescription =
                            editFirstNameContentDescription,
                        onEditClick = {
                            onEditFieldClick(
                                ProfileField.FIRST_NAME,
                            )
                        },
                    )

                    ProfileField(
                        label = lastNameLabel,
                        value = state.lastName,
                        iconResId =
                            R.drawable.ic_profile_user,
                        iconContentDescription =
                            userIconContentDescription,
                        editContentDescription =
                            editLastNameContentDescription,
                        onEditClick = {
                            onEditFieldClick(
                                ProfileField.LAST_NAME,
                            )
                        },
                    )

                    ProfileField(
                        label = phoneLabel,
                        value = state.phoneNumber,
                        iconResId =
                            R.drawable.ic_profile_phone,
                        iconContentDescription =
                            phoneIconContentDescription,
                        editContentDescription =
                            editPhoneContentDescription,
                        onEditClick = {
                            onEditFieldClick(
                                ProfileField.PHONE_NUMBER,
                            )
                        },
                    )

                    ProfileField(
                        label = emailLabel,
                        value = state.email,
                        iconResId =
                            R.drawable.ic_profile_email,
                        iconContentDescription =
                            emailIconContentDescription,
                        editContentDescription =
                            editEmailContentDescription,
                        onEditClick = {
                            onEditFieldClick(
                                ProfileField.EMAIL,
                            )
                        },
                    )

                    SubscriptionField(
                        label = subscriptionLabel,
                        subscription = state.subscription,
                        iconContentDescription =
                            subscriptionIconContentDescription,
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
                    title = logoutTitle,
                    description = logoutDescription,
                    contentDescription =
                        logoutContentDescription,
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
            state = PreviewData.profileUiState,
            onBackClick = {},
            onAvatarEditClick = {},
            onEditFieldClick = {},
            onLogoutClick = {},
            onSaveClick = {},
        )
    }
}
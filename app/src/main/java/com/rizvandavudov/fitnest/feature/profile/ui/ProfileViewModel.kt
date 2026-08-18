package com.rizvandavudov.fitnest.feature.profile.ui

import androidx.lifecycle.ViewModel
import com.rizvandavudov.fitnest.feature.profile.ProfileUiMapper
import com.rizvandavudov.fitnest.feature.profile.data.ProfileDataSource
import com.rizvandavudov.fitnest.feature.profile.data.ProfileFakeRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class ProfileField {
    FIRST_NAME,
    LAST_NAME,
    PHONE_NUMBER,
    EMAIL,
}

sealed interface ProfileUiEvent {

    data class EditRequested(
        val field: ProfileField,
    ) : ProfileUiEvent

    data object SaveRequested : ProfileUiEvent

    data object LogoutRequested : ProfileUiEvent
}

class ProfileViewModel(
    private val profileDataSource: ProfileDataSource =
        ProfileFakeRepo(),
    private val profileUiMapper: ProfileUiMapper =
        ProfileUiMapper(),
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        profileUiMapper.map(
            dataSource = profileDataSource,
        ),
    )

    val uiState: StateFlow<ProfileUiState> =
        _uiState.asStateFlow()

    private val _uiEvent =
        MutableStateFlow<ProfileUiEvent?>(null)

    val uiEvent: StateFlow<ProfileUiEvent?> =
        _uiEvent.asStateFlow()

    fun onEditFieldClick(
        field: ProfileField,
    ) {
        _uiEvent.value = ProfileUiEvent.EditRequested(
            field = field,
        )
    }

    fun onSaveClick() {
        _uiEvent.value =
            ProfileUiEvent.SaveRequested
    }

    fun onLogoutClick() {
        _uiEvent.value =
            ProfileUiEvent.LogoutRequested
    }

    fun onUiEventHandled() {
        _uiEvent.value = null
    }
}
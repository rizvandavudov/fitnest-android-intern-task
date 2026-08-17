package com.rizvandavudov.fitnest.feature.profile

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ProfileViewModelTest {

    @Test
    fun `initial state contains Profile sample data`() {
        val viewModel = ProfileViewModel()

        assertEquals(
            ProfileSampleData.state,
            viewModel.uiState.value,
        )
    }

    @Test
    fun `save click publishes save requested event`() {
        val viewModel = ProfileViewModel()

        viewModel.onSaveClick()

        assertEquals(
            ProfileUiEvent.SaveRequested,
            viewModel.uiEvent.value,
        )
    }

    @Test
    fun `logout click publishes logout requested event`() {
        val viewModel = ProfileViewModel()

        viewModel.onLogoutClick()

        assertEquals(
            ProfileUiEvent.LogoutRequested,
            viewModel.uiEvent.value,
        )
    }

    @Test
    fun `edit click publishes selected field`() {
        val viewModel = ProfileViewModel()

        viewModel.onEditFieldClick(
            field = ProfileField.EMAIL,
        )

        assertEquals(
            ProfileUiEvent.EditRequested(
                field = ProfileField.EMAIL,
            ),
            viewModel.uiEvent.value,
        )
    }

    @Test
    fun `handled event is cleared`() {
        val viewModel = ProfileViewModel()

        viewModel.onSaveClick()
        viewModel.onUiEventHandled()

        assertNull(
            viewModel.uiEvent.value,
        )
    }
}
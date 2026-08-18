package com.rizvandavudov.fitnest.feature.home

import com.rizvandavudov.fitnest.feature.home.ui.BottomNavigationDestination
import com.rizvandavudov.fitnest.feature.home.ui.HomeViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class HomeViewModelTest {

    @Test
    fun `initial state contains Home sample data`() {
        val viewModel = HomeViewModel()

        val state = viewModel.uiState.value

        assertEquals("AS", state.initials)
        assertEquals("Salam, Nigar!", state.greeting)
        assertEquals(
            BottomNavigationDestination.HOME,
            state.selectedNavigationItem,
        )
        assertFalse(state.categories.isEmpty())
        assertFalse(state.marketItems.isEmpty())
        assertFalse(state.gyms.isEmpty())
        assertTrue(state.bottomNavigationItems.isNotEmpty())
    }

    @Test
    fun `disabled navigation item does not change selection`() {
        val viewModel = HomeViewModel()

        viewModel.onNavigationItemClick(
            BottomNavigationDestination.SEARCH,
        )

        assertEquals(
            BottomNavigationDestination.HOME,
            viewModel.uiState.value.selectedNavigationItem,
        )
    }
}
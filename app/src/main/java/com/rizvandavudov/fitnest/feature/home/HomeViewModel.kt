package com.rizvandavudov.fitnest.feature.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeSampleData.state,
    )

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onNavigationItemClick(
        destination: BottomNavigationDestination,
    ) {
        val selectedItem = _uiState.value.bottomNavigationItems.firstOrNull { item ->
                item.destination == destination
            }

        if (selectedItem?.isEnabled != true) {
            return
        }

        _uiState.update { currentState ->
            currentState.copy(
                selectedNavigationItem = destination,
            )
        }
    }
}
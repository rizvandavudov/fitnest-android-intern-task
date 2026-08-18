package com.rizvandavudov.fitnest.feature.home

import androidx.lifecycle.ViewModel
import com.rizvandavudov.fitnest.feature.home.data.FakeRepo
import com.rizvandavudov.fitnest.feature.home.data.HomeDataSource
import com.rizvandavudov.fitnest.feature.home.ui.mapper.HomeUiMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(
    private val homeDataSource: HomeDataSource = FakeRepo(),
    private val homeUiMapper: HomeUiMapper = HomeUiMapper(),
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        homeUiMapper.map(
            dataSource = homeDataSource,
        ),
    )

    val uiState: StateFlow<HomeUiState> =
        _uiState.asStateFlow()

    fun onNavigationItemClick(
        destination: BottomNavigationDestination,
    ) {
        val selectedItem =
            _uiState.value.bottomNavigationItems
                .firstOrNull { item ->
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
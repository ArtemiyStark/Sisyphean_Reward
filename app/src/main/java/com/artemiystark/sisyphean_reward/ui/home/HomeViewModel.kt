package com.artemiystark.sisyphean_reward.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemiystark.sisyphean_reward.data.Task
import com.artemiystark.sisyphean_reward.data.Repository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class HomeViewModel(repository: Repository) : ViewModel() {


    val homeUiState: StateFlow<HomeUiState> =
        repository.getAllTasks().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}


data class HomeUiState(val taskList: List<Task> = listOf())

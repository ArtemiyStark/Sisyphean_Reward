package com.artemiystark.sisyphean_reward.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemiystark.sisyphean_reward.Graph
import com.artemiystark.sisyphean_reward.data.Repository
import com.artemiystark.sisyphean_reward.data.Task
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository = Graph.repository
):ViewModel() {
    var state by mutableStateOf(HomeState())
        private set
    init {
        getTasks()
    }

    private fun getTasks(){
        viewModelScope.launch {
            repository.tasks.collectLatest {
                state = state.copy(
                    tasks = it
                )
            }
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }
}

data class HomeState (
    val tasks:List<Task> = emptyList()
)
package com.artemiystark.sisyphean_reward.ui.task


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemiystark.sisyphean_reward.data.Repository

import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class TaskEditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {


    var taskUiState by mutableStateOf(TaskUiState())
        private set

    private val taskId: Int = checkNotNull(savedStateHandle[TaskEditDestination.taskIdArg])

    init {
        viewModelScope.launch {
            taskUiState = repository.getTask(taskId)
                .filterNotNull()
                .first()
                .toItemUiState(true)
        }
    }


    suspend fun updateTask() {
        if (validateInput(taskUiState.taskDetails)) {
            repository.updateTask(taskUiState.taskDetails.toTask())
        }
    }


    fun updateUiState(taskDetails: TaskDetails) {
        taskUiState =
            TaskUiState(taskDetails = taskDetails, isEntryValid = validateInput(taskDetails))
    }

    private fun validateInput(uiState: TaskDetails = taskUiState.taskDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && steps.isNotBlank() && points.isNotBlank()
        }
    }
}

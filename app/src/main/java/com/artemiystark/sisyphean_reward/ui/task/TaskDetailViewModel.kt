package com.artemiystark.sisyphean_reward.ui.task

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemiystark.sisyphean_reward.data.Repository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class TaskDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: Repository,
) : ViewModel() {

    private val taskId: Int = checkNotNull(savedStateHandle[TaskDetailsDestination.taskIdArg])

    val uiState: StateFlow<TaskDetailsUiState> =
        repository.getTask(taskId)
            .filterNotNull()
            .map {
                //TaskDetailsUiState(active = (it.steps - it.currentStep) <= 0, taskDetails = it.toTaskDetails())
                TaskDetailsUiState(active = true, taskDetails = it.toTaskDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = TaskDetailsUiState()
            )


    fun runOneStep() {
        viewModelScope.launch {
            val currentTask = uiState.value.taskDetails.toTask()
            if (currentTask.currentStep < currentTask.steps) {
                repository.updateTask(currentTask.copy(currentStep = currentTask.currentStep + 1))
            }
        }
    }


    suspend fun deleteItem() {
        repository.deleteTask(uiState.value.taskDetails.toTask())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class TaskDetailsUiState(
    val active: Boolean = true,
    val taskDetails: TaskDetails = TaskDetails()
)

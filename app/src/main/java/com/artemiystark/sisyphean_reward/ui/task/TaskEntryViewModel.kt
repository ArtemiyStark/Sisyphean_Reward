package com.artemiystark.sisyphean_reward.ui.task

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.artemiystark.sisyphean_reward.data.Repository
import com.artemiystark.sisyphean_reward.data.Task
import java.util.Date


class TaskEntryViewModel(private val Repository: Repository) : ViewModel() {


    var taskUiState by mutableStateOf(TaskUiState())
        private set


    fun updateUiState(taskDetails: TaskDetails) {
        taskUiState =
            TaskUiState(taskDetails = taskDetails, isEntryValid = validateInput(taskDetails))
    }


    suspend fun saveItem() {
        if (validateInput()) {
            Repository.insertTask(taskUiState.taskDetails.toTask())
        }
    }

    private fun validateInput(uiState: TaskDetails = taskUiState.taskDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && steps.isNotBlank() && points.isNotBlank()
        }
    }
}


data class TaskUiState(
    val taskDetails: TaskDetails = TaskDetails(),
    val isEntryValid: Boolean = false
)

data class TaskDetails(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val steps: String = "",
    val currentStep: String = "",
    val points: String = ""
)


fun TaskDetails.toTask(): Task = Task(
    id = id,
    name = name,
    description = description,
    steps = steps.toIntOrNull() ?: 0,
    currentStep = currentStep.toIntOrNull() ?: 0,
    points = points.toIntOrNull() ?: 1,
    lastRunTime = Date(),
    nextRunTime = Date()
)


fun Task.toItemUiState(isEntryValid: Boolean = false): TaskUiState = TaskUiState(
    taskDetails = this.toTaskDetails(),
    isEntryValid = isEntryValid
)


fun Task.toTaskDetails(): TaskDetails = TaskDetails(
    id = id,
    name = name,
    description = description,
    steps = steps.toString(),
    currentStep = currentStep.toString(),
    points = points.toString()
)

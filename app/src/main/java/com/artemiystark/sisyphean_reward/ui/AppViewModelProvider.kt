package com.artemiystark.sisyphean_reward.ui


import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.artemiystark.sisyphean_reward.Graph
import com.artemiystark.sisyphean_reward.SRApplication
import com.artemiystark.sisyphean_reward.ui.home.HomeViewModel
import com.artemiystark.sisyphean_reward.ui.task.TaskDetailViewModel
import com.artemiystark.sisyphean_reward.ui.task.TaskEditViewModel
import com.artemiystark.sisyphean_reward.ui.task.TaskEntryViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            TaskEditViewModel(
                this.createSavedStateHandle(),
                Graph.repository
            )
        }

        initializer {
            TaskEntryViewModel(Graph.repository)
        }


        initializer {
            TaskDetailViewModel(
                this.createSavedStateHandle(),
                Graph.repository
            )
        }


        initializer {
            HomeViewModel(Graph.repository)
        }
    }
}


fun CreationExtras.srApplication(): SRApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as SRApplication)

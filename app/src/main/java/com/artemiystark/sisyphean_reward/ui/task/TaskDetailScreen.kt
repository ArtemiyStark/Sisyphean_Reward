package com.artemiystark.sisyphean_reward.ui.task

import com.artemiystark.sisyphean_reward.navigation.NavigationDestination
import com.artemiystark.sisyphean_reward.R

object TaskDetailsDestination : NavigationDestination {
    override val route = "task_details"
    override val titleRes = R.string.task_detail_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}
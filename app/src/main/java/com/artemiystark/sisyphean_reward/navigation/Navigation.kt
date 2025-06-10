package com.artemiystark.sisyphean_reward.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.artemiystark.sisyphean_reward.ui.home.HomeDestination
import com.artemiystark.sisyphean_reward.ui.home.HomeScreen
import com.artemiystark.sisyphean_reward.ui.task.TaskDetailsDestination
import com.artemiystark.sisyphean_reward.ui.task.TaskDetailsScreen
import com.artemiystark.sisyphean_reward.ui.task.TaskEntryScreen
import com.artemiystark.sisyphean_reward.ui.task.TaskEntryDestination
import com.artemiystark.sisyphean_reward.ui.task.TaskEditScreen
import com.artemiystark.sisyphean_reward.ui.task.TaskEditDestination


@Composable
fun SRNavigation(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
 ) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToTaskEntry = { navController.navigate(TaskEntryDestination.route) },
                navigateToTaskUpdate = {
                    navController.navigate("${TaskDetailsDestination.route}/${it}")
                }
            )

        }
        composable(route = TaskEntryDestination.route) {
            TaskEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(
            route = TaskDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(TaskDetailsDestination.taskIdArg) {
                type = NavType.IntType
            })
        ) {
            TaskDetailsScreen(
                navigateToEditTask = { navController.navigate("${TaskEditDestination.route}/$it") },
                //navigateBack = { navController.navigateUp() }
                navigateBack = { navController.navigate(HomeDestination.route)}
            )
        }
        composable(
            route = TaskEditDestination.routeWithArgs,
            arguments = listOf(navArgument(TaskEditDestination.taskIdArg) {
                type = NavType.IntType
            })
        ) {
            TaskEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}
package com.artemiystark.sisyphean_reward

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.artemiystark.sisyphean_reward.ui.home.HomeScreen
import com.artemiystark.sisyphean_reward.ui.task.TaskDetailsDestination
import com.artemiystark.sisyphean_reward.ui.task.TaskEntryDestination

enum class Routes {
    Home,
    Detail
}

@Composable
fun SRNavigation(
    navHostController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.Home.name
    ) {
        composable(route = Routes.Home.name) {
            HomeScreen(
                onNavigate = { navHostController.navigate(TaskEntryDestination.route) },
                navigateToTaskUpdate = {
                    navHostController.navigate("${TaskDetailsDestination.route}/${it}")
                }
            )

        }
//        composable(
//            route = "${Routes.Detail.name}?id={id}",
//            arguments = listOf(navArgument("id") { type = NavType.IntType })
//        ) {
//            val id = it.arguments?.getInt("id") ?: -1
//            DetailScreen(id = id) {
//                navHostController.navigateUp()
//            }
//        }
    }
}
package org.example.project.ktorapitestcmp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.example.project.ktorapitestcmp.HomeViewModel
import org.example.project.ktorapitestcmp.presentation.DetailScreen
import org.example.project.ktorapitestcmp.presentation.MainScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Main.route,
    viewModel: HomeViewModel = HomeViewModel()
) {
    NavHost(
        navController,
        startDestination
    ) {
        composable(Screen.Main.route) {
            MainScreen(navController, viewModel)
        }
        composable(
            route = "${Screen.Detail.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val coinId = backStackEntry.arguments?.getString("id") ?: ""
            DetailScreen(navController, coinId, viewModel)
        }
    }
}
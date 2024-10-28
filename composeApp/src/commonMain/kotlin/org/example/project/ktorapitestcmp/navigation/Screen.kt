package org.example.project.ktorapitestcmp.navigation

sealed class Screen(val route: String) {
    data object Main: Screen("main")
    data object Detail: Screen("detail")
}
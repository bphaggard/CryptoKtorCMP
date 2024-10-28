package org.example.project.ktorapitestcmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.example.project.ktorapitestcmp.navigation.SetupNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()
        SetupNavGraph(navController)
    }
}
package org.example.project.ktorapitestcmp

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

val state = WindowState(
    size = DpSize(500.dp, 780.dp),
    position = WindowPosition(200.dp, 100.dp)
)

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KtorApiTestCMP",
        state = state
    ) {
        App()
    }
}
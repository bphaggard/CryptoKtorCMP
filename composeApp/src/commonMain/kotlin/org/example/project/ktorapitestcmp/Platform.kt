package org.example.project.ktorapitestcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
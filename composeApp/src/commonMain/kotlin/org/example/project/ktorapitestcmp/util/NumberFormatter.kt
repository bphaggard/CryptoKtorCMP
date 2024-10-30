package org.example.project.ktorapitestcmp.util

import androidx.compose.runtime.Composable

@Composable
fun DisplayFormattedNumber(number: String): String {
    // Find the decimal point, and truncate after two decimals
    val formattedNumber = number.let {
        if (it.contains(".")) {
            val integerPart = it.substringBefore(".")
            val decimalPart = it.substringAfter(".").take(3)
            "$integerPart.$decimalPart"
        } else {
            it // If there is no decimal part, return as is
        }
    }
    return formattedNumber
}
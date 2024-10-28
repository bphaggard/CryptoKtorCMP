package org.example.project.ktorapitestcmp.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import ktorapitestcmp.composeapp.generated.resources.DancingScript_Bold
import ktorapitestcmp.composeapp.generated.resources.DancingScript_Medium
import ktorapitestcmp.composeapp.generated.resources.DancingScript_Regular
import ktorapitestcmp.composeapp.generated.resources.DancingScript_SemiBold
import ktorapitestcmp.composeapp.generated.resources.Res
import ktorapitestcmp.composeapp.generated.resources.bebasneue
import ktorapitestcmp.composeapp.generated.resources.djbcoffee
import ktorapitestcmp.composeapp.generated.resources.orbitron
import ktorapitestcmp.composeapp.generated.resources.oswald_light
import org.jetbrains.compose.resources.Font

//Custom fonts
@Composable
fun GetBebasFontFamily() = FontFamily(Font(Res.font.bebasneue))

@Composable
fun GetDjbCoffeeFontFamily() = FontFamily(Font(Res.font.djbcoffee))

@Composable
fun GetOswaldFontLightFamily() = FontFamily(Font(Res.font.oswald_light))

@Composable
fun GetDancingRegularFamily() = FontFamily(Font(Res.font.DancingScript_Regular))

@Composable
fun GetDancingMediumFamily() = FontFamily(Font(Res.font.DancingScript_Medium))

@Composable
fun GetDancingBoldFamily() = FontFamily(Font(Res.font.DancingScript_Bold))

@Composable
fun GetDancingSemiBoldFamily() = FontFamily(Font(Res.font.DancingScript_SemiBold))

@Composable
fun GetOrbitronRegularFamily() = FontFamily(Font(Res.font.orbitron))
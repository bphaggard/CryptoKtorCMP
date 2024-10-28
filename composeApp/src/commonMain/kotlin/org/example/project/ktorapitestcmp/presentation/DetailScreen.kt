package org.example.project.ktorapitestcmp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.project.ktorapitestcmp.HomeViewModel
import org.example.project.ktorapitestcmp.navigation.Screen
import org.example.project.ktorapitestcmp.ui.theme.KtorDark
import org.example.project.ktorapitestcmp.ui.theme.KtorLight
import org.example.project.ktorapitestcmp.util.DisplayFormattedNumber
import org.example.project.ktorapitestcmp.util.GetBebasFontFamily
import kotlin.math.floor
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    id: String,
    viewModel: HomeViewModel
) {
    val colors = if (!isSystemInDarkTheme()) KtorLight else KtorDark
    val coin = viewModel.getCoinById(id)

    MaterialTheme(colorScheme = colors) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
//                        Text(
//                            text = coin?.name ?: "Coin Details",
//                            fontFamily = GetBebasFontFamily())
                            },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack(Screen.Main.route, inclusive = false) }) {
                            Icon(
                                Icons.AutoMirrored.Rounded.ArrowBack,
                                "backIcon",
                                modifier = Modifier.background(
                                    shape = CircleShape,
                                    color = MaterialTheme.colorScheme.surfaceDim)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent)
                )
            },
            containerColor = MaterialTheme.colorScheme.background,
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    coin?.let {
                        Text(
                            it.name,
                            fontFamily = GetBebasFontFamily(),
                            fontSize = 30.sp
                        )
                    }
                    Spacer(Modifier.padding(8.dp))
                    Card(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(0.9f),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceDim)
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            coin?.let {
                                Text(
                                    text = "Coin informations:",
                                    fontFamily = GetBebasFontFamily(),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Symbol: ${it.symbol}")
                                Text(
                                    text = "Price: $${DisplayFormattedNumber(it.priceUsd)}",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Supply: ${floor(it.supply.toDouble()).toInt()} ${it.symbol}",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "Market Cap: $${DisplayFormattedNumber(it.marketCapUsd)}",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = "24h Volume: $${DisplayFormattedNumber(it.volumeUsd24Hr)}",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "24h Change:")
                                    Spacer(Modifier.width(8.dp))
                                    Text(
                                        text = "${DisplayFormattedNumber(it.changePercent24Hr)}%",
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        color = if (it.changePercent24Hr >= 0.toString()) Color.Green else Color.Red
                                    )
                                }
                            } ?: Text("Coin not found")
                        }
                    }
                }
            }
        )
    }
}
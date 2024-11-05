package org.example.project.ktorapitestcmp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.example.project.ktorapitestcmp.HomeViewModel
import org.example.project.ktorapitestcmp.navigation.Screen
import org.example.project.ktorapitestcmp.presentation.parts.CurrenciesCard
import org.example.project.ktorapitestcmp.ui.theme.KtorDark
import org.example.project.ktorapitestcmp.ui.theme.KtorLight
import org.example.project.ktorapitestcmp.util.DisplayFormattedNumber
import org.example.project.ktorapitestcmp.util.GetBebasFontFamily
import kotlin.math.floor

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
                        Text(
                            text = coin?.name ?: "Coin Details",
                            fontFamily = GetBebasFontFamily(),
                            fontSize = 30.sp)
                            },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack(Screen.Main.route, inclusive = false) }) {
                            Icon(
                                Icons.AutoMirrored.Rounded.ArrowBack,
                                "backIcon",
                                modifier = Modifier.background(
                                    shape = CircleShape,
                                    color = MaterialTheme.colorScheme.secondary),
                                tint = MaterialTheme.colorScheme.onSecondary
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent)
                )
            },
            containerColor = MaterialTheme.colorScheme.surfaceDim,
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(0.9f),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            coin?.let {
                                Text(
                                    text = "Coin information's:",
                                    fontFamily = GetBebasFontFamily(),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "Rank: #${it.rank}")
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
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "convert your ${coin?.symbol} assets",
                            fontFamily = GetBebasFontFamily(),
                            fontSize = 26.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(0.8f),
                            value = "",
                            onValueChange = {},
                            label = { Text("enter your ${coin?.symbol} amount") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                        )
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(15.dp),
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                        ) {
                            Text("CONVERT")
                        }
                        coin?.symbol?.let {
                            CurrenciesCard(
                                usLabel = it,
                                ukLabel = it,
                                euLabel = it,
                                czLabel = it,
                                usValue = 0.toString(),
                                ukValue = 0.toString(),
                                euValue = 0.toString(),
                                czValue = 0.toString()
                            )
                        }
                    }
                }
            }
        )
    }
}
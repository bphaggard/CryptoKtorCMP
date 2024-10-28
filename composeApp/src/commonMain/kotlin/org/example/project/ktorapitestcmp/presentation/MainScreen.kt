package org.example.project.ktorapitestcmp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ktorapitestcmp.composeapp.generated.resources.Res
import ktorapitestcmp.composeapp.generated.resources.blockchain
import ktorapitestcmp.composeapp.generated.resources.btc
import org.example.project.ktorapitestcmp.HomeViewModel
import org.example.project.ktorapitestcmp.data.CryptoCurrency
import org.example.project.ktorapitestcmp.navigation.Screen
import org.example.project.ktorapitestcmp.ui.theme.KtorDark
import org.example.project.ktorapitestcmp.ui.theme.KtorLight
import org.example.project.ktorapitestcmp.util.GetBebasFontFamily
import org.example.project.ktorapitestcmp.util.GetDancingRegularFamily
import org.example.project.ktorapitestcmp.util.GetOswaldFontLightFamily
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val coins by viewModel.coins.collectAsState()
    val colors = if (!isSystemInDarkTheme()) KtorLight else KtorDark

    MaterialTheme(colorScheme = colors) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceDim),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp),
                //elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier.fillMaxHeight(0.5f)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.blockchain),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Column {
                            Text(
                                text = "CryptoCurrency",
                                fontFamily = GetBebasFontFamily(),
                                fontWeight = FontWeight.Normal,
                                fontSize = 35.sp
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "infos about crypto assets",
                                fontFamily = GetDancingRegularFamily(),
                                fontWeight = FontWeight.Normal,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "choose cryptocurrency",
                fontFamily = GetBebasFontFamily(),
                fontSize = 26.sp)
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(coins) { coin ->
                    AssetRow(
                        asset = coin,
                        onClick = {navController.navigate("${Screen.Detail.route}/${coin.id}")}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun AssetRow(
    asset: CryptoCurrency,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(0.9f)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.padding(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.15f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
//                Text(
//                    text = "#${asset.rank}",
//                    fontFamily = GetOswaldFontLightFamily(),
//                    fontSize = 20.sp
//                )
                Image(
                    painterResource(Res.drawable.btc),
                    null,
                    modifier = Modifier.size(60.dp)
                )
            }
            Spacer(Modifier.padding(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.85f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = asset.name,
                    fontFamily = GetOswaldFontLightFamily(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 26.sp
                )
            }
        }
    }
}
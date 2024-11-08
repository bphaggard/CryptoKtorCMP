package org.example.project.ktorapitestcmp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ktorapitestcmp.composeapp.generated.resources.Res
import ktorapitestcmp.composeapp.generated.resources.blockchain
import ktorapitestcmp.composeapp.generated.resources.cancel
import org.example.project.ktorapitestcmp.HomeViewModel
import org.example.project.ktorapitestcmp.navigation.Screen
import org.example.project.ktorapitestcmp.presentation.parts.AssetRow
import org.example.project.ktorapitestcmp.ui.theme.KtorDark
import org.example.project.ktorapitestcmp.ui.theme.KtorLight
import org.example.project.ktorapitestcmp.util.GetBebasFontFamily
import org.example.project.ktorapitestcmp.util.GetDancingRegularFamily
import org.example.project.ktorapitestcmp.util.cryptoNameToImageMap
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
                shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
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
                                text = "crypto prices by market cap",
                                fontFamily = GetDancingRegularFamily(),
                                fontWeight = FontWeight.Normal,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "from coincap.io",
                                fontFamily = GetDancingRegularFamily(),
                                fontWeight = FontWeight.Normal,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "choose cryptocurrency",
                fontFamily = GetBebasFontFamily(),
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(coins) { coin ->
                    val cryptoImage = cryptoNameToImageMap[coin.id]?: Res.drawable.cancel
                    AssetRow(
                        asset = coin,
                        image = cryptoImage,
                        onClick = {navController.navigate("${Screen.Detail.route}/${coin.id}")}
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
package org.example.project.ktorapitestcmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.ktorapitestcmp.data.CryptoCurrency
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.round

@Composable
@Preview
fun App() {
    val viewModel = HomeViewModel()
    val coins by viewModel.coins.collectAsState()

    MaterialTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(coins) { coin ->
                AssetRow(coin)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun AssetRow(asset: CryptoCurrency) {
    val priceNumber = asset.priceUsd
    val marketCapNumber = asset.marketCapUsd
    val dayPercentChange = asset.changePercent24Hr.toDouble()
    val formattedPrice = DisplayFormattedNumber(priceNumber)
    val formattedMarketCap = DisplayFormattedNumber(marketCapNumber)
    val formattedDayPercent = round(dayPercentChange * 100) / 100

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(0.9f),
        shape = RoundedCornerShape(20.dp),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "#${asset.rank}", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = asset.name.uppercase(), style = MaterialTheme.typography.h6)
            }
            Text(
                text = "Price: $$formattedPrice",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "Market Cap: $$formattedMarketCap",
                style = MaterialTheme.typography.body2
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "24h %:", style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "$formattedDayPercent%",
                    style = MaterialTheme.typography.body2,
                    color = if (asset.changePercent24Hr >= 0.toString()) Color.Green else Color.Red
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun DisplayFormattedNumber(number: String): String {
    // Find the decimal point, and truncate after two decimals
    val formattedNumber = number.let {
        if (it.contains(".")) {
            val integerPart = it.substringBefore(".")
            val decimalPart = it.substringAfter(".").take(2)
            "$integerPart.$decimalPart"
        } else {
            it // If there is no decimal part, return as is
        }
    }
    return formattedNumber
}

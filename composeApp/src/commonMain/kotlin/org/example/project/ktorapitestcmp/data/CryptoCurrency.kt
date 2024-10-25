package org.example.project.ktorapitestcmp.data


import kotlinx.serialization.Serializable

@Serializable
data class CryptoCurrency(
    val id: String,
    val rank: String,
    val symbol: String,
    val name: String,
    val supply: String,
    val maxSupply: String?,
    val marketCapUsd: String,
    val volumeUsd24Hr: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val vwap24Hr: String?
)

@Serializable
data class CoinApiResponse(
    val data: List<CryptoCurrency>
)
package org.example.project.ktorapitestcmp.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.ktorapitestcmp.data.CoinApiResponse
import org.example.project.ktorapitestcmp.data.CryptoCurrency

val httpClient = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            isLenient = true
        })
    }
}

suspend fun getCryptoCurrencyApi(): List<CryptoCurrency> {
    val response: CoinApiResponse = httpClient.get("https://api.coincap.io/v2/assets").body()
    return response.data
}
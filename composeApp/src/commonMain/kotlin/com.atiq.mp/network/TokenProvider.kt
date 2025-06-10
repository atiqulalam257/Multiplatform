package com.atiq.mp.network

// Shared Token Provider (can be replaced with your Koin-based implementation)
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

object TokenProvider {
    var token: String? = null

    private val apiKey = "6adffb02392b00014544657ed513c870"
    lateinit var client: HttpClient

    suspend fun refreshToken(): String {
        println("Refreshing token...")

        val response: RequestTokenResponseModel = client.get("https://api.themoviedb.org/3/authentication/token/new") {
            parameter("api_key", apiKey)
            contentType(ContentType.Application.Json)
        }.body()

        token = response.request_token
        return token!!
    }
}

@Serializable
data class RequestTokenResponseModel(
    val success: Boolean,
    val expires_at: String,
    val request_token: String
)


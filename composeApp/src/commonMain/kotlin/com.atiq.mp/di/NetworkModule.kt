package com.atiq.mp.di

import com.atiq.mp.data.account.AccountService
import com.atiq.mp.data.account.AccountServiceImpl
import com.atiq.mp.data.artist.ArtistService
import com.atiq.mp.data.artist.ArtistServiceImpl
import com.atiq.mp.data.favorite.FavoriteService
import com.atiq.mp.data.favorite.FavoriteServiceImpl
import com.atiq.mp.data.tv.TvService
import com.atiq.mp.utils.Constants
import com.atiq.mp.data.tv.TvServiceImpl
import com.atiq.mp.network.TokenProvider
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module

@OptIn(ExperimentalSerializationApi::class)
val networkModule = module {
    single {
        HttpClient {
            defaultRequest {
                url {
                    if (this.host.isBlank()) {
                        print(Constants.BASE_URL)
                        takeFrom(Constants.BASE_URL)
                        parameters.append("api_key", Constants.API_KEY)
                    }
                }
            }
            expectSuccess = true
            install(HttpTimeout) {
                val timeout = 30000L
                connectTimeoutMillis = timeout
                requestTimeoutMillis = timeout
                socketTimeoutMillis = timeout
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
        }
    }

    single {
        val client: HttpClient = get()
        TokenProvider.client = client
    }

    single<AccountService> { AccountServiceImpl(get()) }

    single<TvService> { TvServiceImpl(get()) }
    single<FavoriteService> { FavoriteServiceImpl(get()) }
    single<ArtistService> { ArtistServiceImpl(get()) }
    /*single<NominatimService> {
        val client = get<HttpClient>()
        NominatimServiceImpl(client)
    }*/
}

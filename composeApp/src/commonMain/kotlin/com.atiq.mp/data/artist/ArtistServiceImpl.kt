package com.atiq.mp.data.artist

import com.atiq.mp.network.getWithAuthRetry
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArtistServiceImpl(private val client: HttpClient): ArtistService {

    override suspend fun artistDetail(personId: Int): ArtistDetailModel {
        return client.getWithAuthRetry("person/$personId")
    }

    override suspend fun artistCredit(personId: Int): ArtistCreditsModel {
        return client.getWithAuthRetry("person/$personId/combined_credits")
    }
}

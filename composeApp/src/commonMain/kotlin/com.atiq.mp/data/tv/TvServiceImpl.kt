package com.atiq.mp.data.tv

import com.atiq.mp.data.artist.CreditsModel
import com.atiq.mp.data.favorite.AccountStateResponseModel
import com.atiq.mp.network.getWithAuthRetry
import io.ktor.client.HttpClient

class TvServiceImpl(private val client: HttpClient) : TvService {

    override suspend fun popularTv(): PopularTvModel {
        return client.getWithAuthRetry(POPULAR_TV)
    }

    override suspend fun topRatedTv(): TopRatedTvModel {
        return client.getWithAuthRetry(TOP_RATED_TV)
    }

    override suspend fun tvDetail(tvId: Int): TvDetailModel {
        return client.getWithAuthRetry("tv/$tvId")
    }

    override suspend fun tvCredit(tvId: Int): CreditsModel {
        return client.getWithAuthRetry("tv/$tvId/credits")
    }

    override suspend fun getTvState(sessionId: String, tvId: Int): AccountStateResponseModel {
        val url = "tv/$tvId/account_states?session_id=$sessionId"
        return client.getWithAuthRetry(url)
    }


    companion object {
        const val POPULAR_TV = "tv/popular"
        const val TOP_RATED_TV = "tv/top_rated"
    }
}
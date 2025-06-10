package com.atiq.mp.data.tv

import com.atiq.mp.data.artist.CreditsModel
import com.atiq.mp.data.favorite.AccountStateResponseModel

interface TvService {

    suspend fun popularTv(): PopularTvModel

    suspend fun topRatedTv(): TopRatedTvModel

    suspend fun tvDetail(tvId: Int): TvDetailModel

    suspend fun tvCredit(tvId: Int): CreditsModel

    suspend fun getTvState(sessionId: String, tvId: Int): AccountStateResponseModel
}

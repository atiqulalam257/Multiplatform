package com.atiq.mp.domain.tv

import com.atiq.mp.domain.artist.Credits
import com.atiq.mp.domain.favorite.TvAccountState

interface TvRepository {

    suspend fun getPopularTv(): Result<List<PopularTv>>

    suspend fun getTopRatedTv(): Result<List<TopRatedTv>>

    suspend fun getTvDetail(tvId: Int): Result<TvDetail>

    suspend fun getTvCredits(tvId: Int): Result<List<Credits>>

    suspend fun getTvAccountState(tvId: Int): Result<TvAccountState>

}

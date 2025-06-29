package com.atiq.mp.data.tv

import com.atiq.mp.domain.account.SessionSettings
import com.atiq.mp.domain.artist.Credits
import com.atiq.mp.domain.favorite.TvAccountState
import com.atiq.mp.domain.tv.PopularTv
import com.atiq.mp.domain.tv.TopRatedTv
import com.atiq.mp.domain.tv.TvDetail
import com.atiq.mp.domain.tv.TvRepository
import com.atiq.mp.utils.resultOf

class TvRepositoryImpl(
    private val service: TvService,
    private val sessionSettings: SessionSettings
) : TvRepository {

    override suspend fun getPopularTv(): Result<List<PopularTv>> {
        return resultOf {
            service.popularTv().tvSeries.map { it.toDomain() }
        }
    }

    override suspend fun getTopRatedTv(): Result<List<TopRatedTv>> {
        return resultOf {
            service.topRatedTv().tvSeries.map { it.toDomain() }
        }
    }

    override suspend fun getTvDetail(tvId: Int): Result<TvDetail> {
        return resultOf {
            service.tvDetail(tvId).toDomain()
        }
    }

    override suspend fun getTvCredits(tvId: Int): Result<List<Credits>> {
        return resultOf {
            service.tvCredit(tvId).cast.map { it.toDomain() }
        }
    }

    override suspend fun getTvAccountState(tvId: Int): Result<TvAccountState> {
        return resultOf {
            val response = service.getTvState(
                sessionId = sessionSettings.getSessionId() ?: "", tvId
            )
            TvAccountState(response.favorite ?: false, response.rated)
        }
    }
}

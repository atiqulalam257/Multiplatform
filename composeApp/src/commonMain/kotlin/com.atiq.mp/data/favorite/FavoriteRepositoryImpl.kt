package com.atiq.mp.data.favorite

import com.atiq.mp.domain.account.SessionSettings
import com.atiq.mp.domain.favorite.FavoriteMovie
import com.atiq.mp.domain.favorite.FavoriteRepository
import com.atiq.mp.domain.favorite.FavoriteTv
import com.atiq.mp.utils.resultOf

class FavoriteRepositoryImpl(
    private val service: FavoriteService,
    private val sessionSettings: SessionSettings
) : FavoriteRepository {

    override suspend fun addFavorite(
        accountId: Int,
        addFavoriteRequestModel: AddFavoriteRequestModel
    ): Result<AddFavoriteResponseModel> {
        return resultOf {
            service.addFavorite(
                accountId,
                addFavoriteRequestModel,
                sessionSettings.getSessionId() ?: ""
            )
        }
    }

    override suspend fun getFavoriteMovie(
        accountId: Int,
        sessionId: String
    ): Result<List<FavoriteMovie>> {
        return resultOf {
            service.getFavoriteMovie(
                accountId = accountId,
                sessionId = sessionId
            ).favMovies.map { it.toDomain() }
        }
    }

    override suspend fun getFavoriteTv(
        accountId: Int,
        sessionId: String
    ): Result<List<FavoriteTv>> {
        return resultOf {
            service.getFavoriteTv(
                accountId = accountId,
                sessionId = sessionId
            ).favTv.map { it.toDomain() }
        }
    }
}

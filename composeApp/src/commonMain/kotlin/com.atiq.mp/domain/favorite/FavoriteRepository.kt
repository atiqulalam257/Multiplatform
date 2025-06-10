package com.atiq.mp.domain.favorite

import com.atiq.mp.data.favorite.AddFavoriteRequestModel
import com.atiq.mp.data.favorite.AddFavoriteResponseModel

interface FavoriteRepository {

    suspend fun addFavorite(
        accountId: Int,
        addFavoriteRequestModel: AddFavoriteRequestModel
    ): Result<AddFavoriteResponseModel>

    suspend fun getFavoriteMovie(accountId: Int, sessionId: String): Result<List<FavoriteMovie>>

    suspend fun getFavoriteTv(accountId: Int, sessionId: String): Result<List<FavoriteTv>>
}

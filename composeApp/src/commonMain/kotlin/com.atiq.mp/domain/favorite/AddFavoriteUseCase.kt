package com.atiq.mp.domain.favorite

import com.atiq.mp.data.favorite.AddFavoriteRequestModel


class AddFavoriteUseCase(private val repository: FavoriteRepository) {

    suspend fun execute(
        accountId: Int,
        mediaId: Int,
        mediaType: String,
        isFavorite: Boolean
    ): Result<Unit> {
        val result = repository.addFavorite(
            accountId = accountId,
            AddFavoriteRequestModel(
                favorite = isFavorite,
                mediaId = mediaId,
                mediaType = mediaType
            )
        )
        return if (result.isSuccess && result.getOrNull()?.success == true) {
            Result.success(Unit)
        } else {
            Result.failure(Throwable())
        }
    }
}

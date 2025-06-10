package com.atiq.mp.domain.favorite

import com.atiq.mp.domain.tv.TvRepository


class GetTvStateUseCase(private val repository: TvRepository) {

    suspend fun execute(mediaId: Int): Result<TvAccountState> {
        return repository.getTvAccountState(mediaId)
    }
}

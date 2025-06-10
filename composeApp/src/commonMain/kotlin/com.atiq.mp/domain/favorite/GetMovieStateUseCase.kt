package com.atiq.mp.domain.favorite

import com.atiq.mp.domain.movie.MovieRepository

class GetMovieStateUseCase(private val repository: MovieRepository) {

    suspend fun execute(mediaId: Int): Result<MovieAccountState> {
        return repository.getMovieAccountState(mediaId)
    }
}

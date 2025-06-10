package com.atiq.mp.domain.movie

import com.atiq.mp.domain.artist.Credits
import com.atiq.mp.domain.favorite.MovieAccountState

interface MovieRepository {

    suspend fun getPopularMovie(): Result<List<PopularMovie>>

    suspend fun getNowPlayingMovie(): Result<List<NowPlayingMovie>>

    suspend fun getMovieDetail(movieId: Int): Result<MovieDetail>

    suspend fun getMovieCredits(movieId: Int): Result<List<Credits>>

    suspend fun getMovieAccountState(movieId: Int): Result<MovieAccountState>
}

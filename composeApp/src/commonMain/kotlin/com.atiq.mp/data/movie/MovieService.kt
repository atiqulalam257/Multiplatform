package com.atiq.mp.data.movie

import com.atiq.mp.data.favorite.AccountStateResponseModel
import com.atiq.mp.data.artist.CreditsModel

interface MovieService {

    suspend fun popularMovie(): PopularMovieModel

    suspend fun nowPlayingMovie(): NowPlayingMovieModel

    suspend fun movieDetail(movieId: Int): MovieDetailModel

    suspend fun movieCredit(movieId: Int): CreditsModel

    suspend fun getMovieState(sessionId: String, movieId: Int): AccountStateResponseModel
}

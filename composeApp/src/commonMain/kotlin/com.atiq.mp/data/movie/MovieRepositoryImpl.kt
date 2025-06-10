package com.atiq.mp.data.movie

import com.atiq.mp.domain.account.SessionSettings
import com.atiq.mp.domain.favorite.MovieAccountState
import com.atiq.mp.domain.movie.MovieDetail
import com.atiq.mp.domain.movie.MovieRepository
import com.atiq.mp.domain.movie.NowPlayingMovie
import com.atiq.mp.domain.movie.PopularMovie
import com.atiq.mp.domain.artist.Credits
import com.atiq.mp.utils.resultOf

class MovieRepositoryImpl(
    private val service: MovieService,
    private val sessionSettings: SessionSettings
) : MovieRepository {
    override suspend fun getPopularMovie(): Result<List<PopularMovie>> {
        return resultOf {
            service.popularMovie().movies.map { it.toDomain() }
        }
    }

    override suspend fun getNowPlayingMovie(): Result<List<NowPlayingMovie>> {
        return resultOf {
            service.nowPlayingMovie().movies.map { it.toDomain() }
        }
    }

    override suspend fun getMovieDetail(movieId: Int): Result<MovieDetail> {
        return resultOf {
            service.movieDetail(movieId).toDomain()
        }
    }

    override suspend fun getMovieCredits(movieId: Int): Result<List<Credits>> {
        return resultOf {
            service.movieCredit(movieId).cast.map { it.toDomain() }
        }
    }

    override suspend fun getMovieAccountState(movieId: Int): Result<MovieAccountState> {
        return resultOf {
            val response = service.getMovieState(
                sessionId = sessionSettings.getSessionId() ?: "",
                movieId
            )
            MovieAccountState(response.favorite ?: false, response.rated)
        }
    }
}

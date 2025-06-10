package com.atiq.mp.data.movie

import com.atiq.mp.data.favorite.AccountStateResponseModel
import com.atiq.mp.data.artist.CreditsModel
import com.atiq.mp.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType

class MovieServiceImpl(
    private val client: HttpClient,
) : MovieService {

    override suspend fun popularMovie(): PopularMovieModel {
        return client.get(POPULAR_MOVIE).body()
    }

    override suspend fun nowPlayingMovie(): NowPlayingMovieModel {
        return client.get(NOW_PLAYING_MOVIE).body()
    }

    override suspend fun movieDetail(movieId: Int): MovieDetailModel {
        return client.get("movie/$movieId").body()
    }

    override suspend fun movieCredit(movieId: Int): CreditsModel {
        return client.get("movie/$movieId/credits").body()
    }

    override suspend fun getMovieState(sessionId: String, movieId: Int): AccountStateResponseModel {
        return client.get("movie/${movieId}/account_states") {
            contentType(ContentType.Application.Json)
            url {
                parameters.append(Constants.SESSION_ID, sessionId)
            }
        }.body()
    }

    companion object {
        const val POPULAR_MOVIE = "movie/popular"
        const val NOW_PLAYING_MOVIE = "movie/now_playing"
    }
}

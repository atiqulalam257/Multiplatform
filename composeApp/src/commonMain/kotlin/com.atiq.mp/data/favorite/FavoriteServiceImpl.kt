package com.atiq.mp.data.favorite

import com.atiq.mp.network.getWithAuthRetry
import com.atiq.mp.network.postWithAuthRetry
import com.atiq.mp.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class FavoriteServiceImpl(
    private val client: HttpClient
) : FavoriteService {

    override suspend fun addFavorite(
        accountId: Int,
        addFavoriteRequestModel: AddFavoriteRequestModel,
        sessionId: String
    ): AddFavoriteResponseModel {
        val url = "account/$accountId/favorite?session_id=$sessionId"
        return client.postWithAuthRetry(url, addFavoriteRequestModel)
    }


    override suspend fun getFavoriteMovie(accountId: Int, sessionId: String): FavoriteMovieModel {
        val url = "account/$accountId/favorite/movies?session_id=$sessionId"
        return client.getWithAuthRetry(url)
    }


    override suspend fun getFavoriteTv(accountId: Int, sessionId: String): FavoriteTvModel {
        val url = "account/$accountId/favorite/tv?session_id=$sessionId"
        return client.getWithAuthRetry(url)
    }

}

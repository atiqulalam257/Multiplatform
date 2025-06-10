package com.atiq.mp.data.account

import com.atiq.mp.data.account.login.LoginRequestModel
import com.atiq.mp.data.account.login.LoginResponseModel
import com.atiq.mp.data.account.login.RequestTokenResponseModel
import com.atiq.mp.data.account.login.SessionRequestModel
import com.atiq.mp.data.account.login.SessionResponseModel
import com.atiq.mp.network.deleteWithAuthRetry
import com.atiq.mp.network.getWithAuthRetry
import com.atiq.mp.network.postWithAuthRetry
import com.atiq.mp.utils.Constants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AccountServiceImpl(
    private val client: HttpClient,
) : AccountService {

    override suspend fun accountDetails(sessionId: String): AccountDetailModel {
        val url = "$ACCOUNT?${Constants.SESSION_ID}=$sessionId"
        return client.getWithAuthRetry(url)
    }

    //login

    override suspend fun createRequestToken(): RequestTokenResponseModel {
        return client.getWithAuthRetry(REQUEST_TOKEN)
    }

    override suspend fun createRequestTokenWithLogin(requestModel: LoginRequestModel): LoginResponseModel {
        return client.postWithAuthRetry(LOGIN,requestModel)
    }

    override suspend fun createSession(requestModel: SessionRequestModel): SessionResponseModel {
        return client.postWithAuthRetry(SESSION,requestModel)
    }


    override suspend fun logout(logoutRequestModel: LogoutRequestModel): LogoutResponseModel {
        return client.deleteWithAuthRetry(LOGOUT,logoutRequestModel)
    }

    companion object {
        const val ACCOUNT = "account"
        const val REQUEST_TOKEN = "authentication/token/new"
        const val LOGIN = "authentication/token/validate_with_login"
        const val SESSION = "authentication/session/new"
        const val LOGOUT = "authentication/session"
    }
}

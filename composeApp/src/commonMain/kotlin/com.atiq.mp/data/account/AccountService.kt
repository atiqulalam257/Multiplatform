package com.atiq.mp.data.account

import com.atiq.mp.data.account.login.LoginRequestModel
import com.atiq.mp.data.account.login.LoginResponseModel
import com.atiq.mp.data.account.login.RequestTokenResponseModel
import com.atiq.mp.data.account.login.SessionRequestModel
import com.atiq.mp.data.account.login.SessionResponseModel

interface AccountService {

    suspend fun accountDetails(sessionId: String): AccountDetailModel

    //login
    suspend fun createRequestToken(): RequestTokenResponseModel

    suspend fun createRequestTokenWithLogin(requestModel: LoginRequestModel): LoginResponseModel

    suspend fun createSession(requestModel: SessionRequestModel): SessionResponseModel

    suspend fun logout(logoutRequestModel: LogoutRequestModel): LogoutResponseModel

}

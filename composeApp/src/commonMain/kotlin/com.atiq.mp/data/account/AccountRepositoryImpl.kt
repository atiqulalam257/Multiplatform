package com.atiq.mp.data.account

import com.atiq.mp.data.account.login.LoginRequestModel
import com.atiq.mp.data.account.login.SessionRequestModel
import com.atiq.mp.domain.account.AccountDetail
import com.atiq.mp.domain.account.AccountRepository
import com.atiq.mp.domain.account.SessionSettings
import com.atiq.mp.utils.invoke
import com.atiq.mp.utils.resultOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AccountRepositoryImpl(
    private val service: AccountService,
    private val sessionSettings: SessionSettings,
) : AccountRepository {
    private val _loginStateFlow = MutableStateFlow(
        if (sessionSettings.doesSessionExist()) {
            LoginState.LOGGED_IN
        } else {
            LoginState.LOGGED_OUT
        }
    )

    override suspend fun getAccountDetail(): Result<AccountDetail> {
        return resultOf {
            service.accountDetails(sessionSettings.getSessionId()!!)
                .run {
                    AccountDetail(id, name, username, country)
                }
        }
    }

    override fun getLoginState(): StateFlow<LoginState> {
        return _loginStateFlow.asStateFlow()
    }

    override suspend fun login(username: String, password: String) = resultOf {
        invoke {
            val requestTokenResponse = service.createRequestToken()

            val loginRequestTokenResponse =
                service.createRequestTokenWithLogin(
                    LoginRequestModel(
                        username = username,
                        password = password,
                        requestToken = requestTokenResponse.requestToken
                    )
                )
            val sessionResponse = service.createSession(
                SessionRequestModel(
                    loginRequestTokenResponse.requestToken
                )
            )
            sessionSettings.setSessionId(sessionResponse.sessionId)
            _loginStateFlow.value = LoginState.LOGGED_IN

            loginRequestTokenResponse
        }
    }

    override suspend fun logout(sessionId: String?): Result<Boolean> {
        return resultOf {
            service.logout(LogoutRequestModel(sessionId!!)).success
        }.onSuccess { if (it) _loginStateFlow.value = LoginState.LOGGED_OUT }
    }
}

enum class LoginState {
    LOGGED_IN,
    LOGGED_OUT
}


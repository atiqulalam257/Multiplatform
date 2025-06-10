package com.atiq.mp.data.account.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SessionRequestModel(
    @SerialName("request_token") val requestToken: String
)

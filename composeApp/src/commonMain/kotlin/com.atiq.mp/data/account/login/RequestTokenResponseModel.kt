package com.atiq.mp.data.account.login

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestTokenResponseModel(
    @SerialName("success") val success: Boolean,
    @SerialName("request_token") val requestToken: String
)

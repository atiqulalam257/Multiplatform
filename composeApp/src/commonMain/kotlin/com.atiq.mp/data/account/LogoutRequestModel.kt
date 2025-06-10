package com.atiq.mp.data.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LogoutRequestModel(
    @SerialName("session_id") val sessionId: String
)

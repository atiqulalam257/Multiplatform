package com.atiq.mp.data.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LogoutResponseModel(
    @SerialName("success") val success: Boolean
)

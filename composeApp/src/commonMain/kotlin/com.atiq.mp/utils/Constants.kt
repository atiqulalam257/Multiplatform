package com.atiq.mp.utils

import com.atiq.mp.BuildKonfig


object Constants {
    val API_KEY = BuildKonfig.API_KEY_TMDB.removeSurrounding("\"")
    val BASE_URL = BuildKonfig.BASE_URL.removeSurrounding("\"")
    val IMAGE_BASE = BuildKonfig.IMAGE_BASE_URL.removeSurrounding("\"")
    val REGISTER = BuildKonfig.REGISTER_URL.removeSurrounding("\"")
    val FORGOT_PASSWORD = BuildKonfig.RESET_PASSWORD_URL.removeSurrounding("\"")

    const val SESSION_ID = "session_id" // This can stay 'const' since it's a literal string
}


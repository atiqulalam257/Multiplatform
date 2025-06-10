package com.atiq.mp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
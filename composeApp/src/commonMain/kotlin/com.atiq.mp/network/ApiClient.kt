package com.atiq.mp.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType

suspend inline fun <reified T> HttpClient.postWithAuthRetry(
    url: String,
    body: Any?
): T {
    val token = TokenProvider.token
    try {
        return post(url) {
            header(HttpHeaders.Authorization, "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(body)
        }.body()
    } catch (e: ClientRequestException) {
        if (e.response.status == HttpStatusCode.Unauthorized) {
            println("401 detected. Refreshing token...")

            val newToken = TokenProvider.refreshToken()
            return post(url) {
                header(HttpHeaders.Authorization, "Bearer $newToken")
                contentType(ContentType.Application.Json)
                setBody(body)
            }.body()
        } else {
            throw e
        }
    }
}

suspend inline fun <reified T> HttpClient.getWithAuthRetry(
    url: String
): T {
    val token = TokenProvider.token
    try {
        return get(url) {
            header(HttpHeaders.Authorization, "Bearer $token")
            contentType(ContentType.Application.Json)
        }.body()
    } catch (e: ClientRequestException) {
        if (e.response.status == HttpStatusCode.Unauthorized) {
            println("401 detected. Refreshing token...")

            val newToken = TokenProvider.refreshToken()
            return get(url) {
                header(HttpHeaders.Authorization, "Bearer $newToken")
                contentType(ContentType.Application.Json)
            }.body()
        } else {
            throw e
        }
    }
}

suspend inline fun <reified T> HttpClient.putWithAuthRetry(
    url: String,
    body: Any?
): T {
    val token = TokenProvider.token
    try {
        return put(url) {
            header(HttpHeaders.Authorization, "Bearer $token")
            contentType(ContentType.Application.Json)
            setBody(body)
        }.body()
    } catch (e: ClientRequestException) {
        if (e.response.status == HttpStatusCode.Unauthorized) {
            println("401 detected. Refreshing token...")

            val newToken = TokenProvider.refreshToken()
            return put(url) {
                header(HttpHeaders.Authorization, "Bearer $newToken")
                contentType(ContentType.Application.Json)
                setBody(body)
            }.body()
        } else {
            throw e
        }
    }
}

suspend inline fun <reified T> HttpClient.deleteWithAuthRetry(
    url: String,
    body: Any? = null
): T {
    val token = TokenProvider.token
    try {
        return delete(url) {
            header(HttpHeaders.Authorization, "Bearer $token")
            contentType(ContentType.Application.Json)
            if (body != null) {
                setBody(body)
            }
        }.body()
    } catch (e: ClientRequestException) {
        if (e.response.status == HttpStatusCode.Unauthorized) {
            println("401 detected. Refreshing token...")

            val newToken = TokenProvider.refreshToken()
            return delete(url) {
                header(HttpHeaders.Authorization, "Bearer $newToken")
                contentType(ContentType.Application.Json)
                if (body != null) {
                    setBody(body)
                }
            }.body()
        } else {
            throw e
        }
    }
}


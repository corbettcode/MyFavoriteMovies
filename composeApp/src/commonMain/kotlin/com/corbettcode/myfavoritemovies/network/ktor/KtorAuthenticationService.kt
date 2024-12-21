package com.corbettcode.myfavoritemovies.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
// import com.corbettcode.myfavoritemovies.network.config.isNeedApiKeyQuery
import com.corbettcode.myfavoritemovies.network.config.tmdbApiKey
import com.corbettcode.myfavoritemovies.network.model.DeletedSession
import com.corbettcode.myfavoritemovies.network.model.RequestToken
import com.corbettcode.myfavoritemovies.network.model.Session
import com.corbettcode.myfavoritemovies.network.model.SessionRequest
import com.corbettcode.myfavoritemovies.network.model.Token
import com.corbettcode.myfavoritemovies.network.model.Username

internal class KtorAuthenticationService(
    private val ktorHttpClient: HttpClient
) {

    suspend fun createRequestToken(): Token {
        return ktorHttpClient.get("authentication/token/new?") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
        }.body()
    }

    suspend fun createSessionWithLogin(
        username: Username
    ): Token {
        return ktorHttpClient.post("authentication/token/validate_with_login?") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
            setBody(username)
        }.body()
    }

    suspend fun createSession(
        authToken: RequestToken
    ): Session {
        return ktorHttpClient.post("authentication/session/new?") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
            setBody(authToken)
        }.body()
    }

    suspend fun deleteSession(
        sessionRequest: SessionRequest
    ): DeletedSession {
        return ktorHttpClient.delete("authentication/session?") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
            setBody(sessionRequest)
        }.body()
    }
}
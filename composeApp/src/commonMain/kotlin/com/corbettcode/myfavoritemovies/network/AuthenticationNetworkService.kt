package com.corbettcode.myfavoritemovies.network

import com.corbettcode.myfavoritemovies.network.ktor.KtorAuthenticationService
import com.corbettcode.myfavoritemovies.network.model.DeletedSession
import com.corbettcode.myfavoritemovies.network.model.RequestToken
import com.corbettcode.myfavoritemovies.network.model.Session
import com.corbettcode.myfavoritemovies.network.model.SessionRequest
import com.corbettcode.myfavoritemovies.network.model.Token
import com.corbettcode.myfavoritemovies.network.model.Username

class AuthenticationNetworkService internal constructor(
    private val ktorAuthenticationService: KtorAuthenticationService
) {

    suspend fun createRequestToken(): Token {
        return ktorAuthenticationService.createRequestToken()
    }

    suspend fun createSessionWithLogin(
        username: Username
    ): Token {
        return ktorAuthenticationService.createSessionWithLogin(username)
    }

    suspend fun createSession(
        authToken: RequestToken
    ): Session {
        return ktorAuthenticationService.createSession(authToken)
    }

    suspend fun deleteSession(
        sessionRequest: SessionRequest
    ): DeletedSession {
        return ktorAuthenticationService.deleteSession(sessionRequest)
    }
}
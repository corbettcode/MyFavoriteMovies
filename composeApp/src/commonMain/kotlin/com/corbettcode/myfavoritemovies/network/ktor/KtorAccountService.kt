package com.corbettcode.myfavoritemovies.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
// import com.corbettcode.myfavoritemovies.network.config.isNeedApiKeyQuery
import com.corbettcode.myfavoritemovies.network.config.tmdbApiKey
import com.corbettcode.myfavoritemovies.network.model.Account

internal class KtorAccountService(
    private val ktorHttpClient: HttpClient
) {

    suspend fun accountDetails(
        sessionId: String
    ): Account {
        return ktorHttpClient.get("account") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
            parameter("session_id", sessionId)
        }.body()
    }
}
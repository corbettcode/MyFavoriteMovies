package com.corbettcode.myfavoritemovies.network

import com.corbettcode.myfavoritemovies.network.ktor.KtorAccountService
import com.corbettcode.myfavoritemovies.network.model.Account

class AccountNetworkService internal constructor(
    private val ktorAccountService: KtorAccountService
) {

    suspend fun accountDetails(
        sessionId: String
    ): Account {
        return ktorAccountService.accountDetails(sessionId)
    }
}
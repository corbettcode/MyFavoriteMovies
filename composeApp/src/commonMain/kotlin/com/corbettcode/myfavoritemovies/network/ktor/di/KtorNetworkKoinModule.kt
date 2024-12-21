package com.corbettcode.myfavoritemovies.network.ktor.di

import org.koin.dsl.module
import com.corbettcode.myfavoritemovies.network.ktor.KtorAccountService
import com.corbettcode.myfavoritemovies.network.ktor.KtorAuthenticationService
import com.corbettcode.myfavoritemovies.network.ktor.KtorMovieService
import com.corbettcode.myfavoritemovies.network.ktor.KtorSearchService

val ktorNetworkKoinModule = module {
    includes(
        ktorKoinModule
    )
    single { KtorAccountService(get()) }
    single { KtorAuthenticationService(get()) }
    single { KtorMovieService(get()) }
    single { KtorSearchService(get()) }
}
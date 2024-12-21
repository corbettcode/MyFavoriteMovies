package com.corbettcode.myfavoritemovies.network

import org.koin.dsl.module
import com.corbettcode.myfavoritemovies.network.okhttp.ApikeyInterceptor

internal val apiKeyInterceptorKoinModule = module {
    single<ApikeyInterceptor> { ApikeyInterceptor(BuildConfig.TMDB_API_KEY) }
}
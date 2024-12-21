package com.corbettcode.myfavoritemovies.network

import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

internal val httpLoggingInterceptorKoinModule = module {
    single<HttpLoggingInterceptor> { HttpLoggingInterceptor() }
}
package com.corbettcode.myfavoritemovies.network.di

import org.koin.dsl.module
import com.corbettcode.myfavoritemovies.network.AccountNetworkService
import com.corbettcode.myfavoritemovies.network.AuthenticationNetworkService
import com.corbettcode.myfavoritemovies.network.MovieNetworkService
import com.corbettcode.myfavoritemovies.network.SearchNetworkService
import com.corbettcode.myfavoritemovies.network.ktor.di.ktorNetworkKoinModule

val networkKoinModule = module {
    includes(
        ktorNetworkKoinModule
    )
    single { AccountNetworkService(get()) }
    single { AuthenticationNetworkService(get()) }
    single { MovieNetworkService(get()) }
    single { SearchNetworkService(get()) }
}
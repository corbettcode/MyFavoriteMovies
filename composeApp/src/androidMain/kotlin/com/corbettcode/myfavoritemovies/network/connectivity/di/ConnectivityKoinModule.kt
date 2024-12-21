package com.corbettcode.myfavoritemovies.network.connectivity.di

import android.net.ConnectivityManager
import androidx.core.content.ContextCompat
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.corbettcode.myfavoritemovies.network.connectivity.NetworkManager
import com.corbettcode.myfavoritemovies.network.connectivity.impl.NetworkManagerImpl

actual val connectivityKoinModule = module {
    single { ContextCompat.getSystemService(androidContext(), ConnectivityManager::class.java) as ConnectivityManager }
    singleOf(::NetworkManagerImpl) { bind<NetworkManager>() }
}
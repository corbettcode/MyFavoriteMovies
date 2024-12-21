package com.corbettcode.myfavoritemovies.network.connectivity

sealed interface NetworkStatus {
    data object Available: NetworkStatus
    data object Unavailable: NetworkStatus
}
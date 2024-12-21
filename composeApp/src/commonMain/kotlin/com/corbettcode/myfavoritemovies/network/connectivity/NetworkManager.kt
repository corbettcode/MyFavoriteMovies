package com.corbettcode.myfavoritemovies.network.connectivity

import kotlinx.coroutines.flow.Flow

interface NetworkManager {
    val status: Flow<NetworkStatus>
}
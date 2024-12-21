package com.corbettcode.myfavoritemovies.network.connectivity.ktx

import com.corbettcode.myfavoritemovies.network.connectivity.NetworkStatus

val NetworkStatus.isAvailable: Boolean
    get() = this == NetworkStatus.Available
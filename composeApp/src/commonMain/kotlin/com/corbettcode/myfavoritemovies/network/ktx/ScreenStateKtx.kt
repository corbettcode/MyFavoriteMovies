package com.corbettcode.myfavoritemovies.network.ktx

import com.corbettcode.myfavoritemovies.network.config.ScreenState

val ScreenState.isFailure: Boolean
    get() = this is ScreenState.Failure

val ScreenState.throwable: Throwable
    get() = (this as ScreenState.Failure).throwable
package com.corbettcode.myfavoritemovies.network.config

import com.corbettcode.myfavoritemovies.network.BuildConfig

actual val tmdbApiKey: String
    get() = BuildConfig.TMDB_API_KEY

actual val isTmdbApiKeyEmpty: Boolean
    get() = tmdbApiKey.isEmpty() || tmdbApiKey == "null"
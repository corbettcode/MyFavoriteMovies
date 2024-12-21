package com.corbettcode.myfavoritemovies.di

import com.corbettcode.myfavoritemovies.data.remote.TmdbClientApi
import com.corbettcode.myfavoritemovies.data.remote.TmdbRepositoryImp

object DataModule {
    val api = TmdbClientApi
    val tmdbRepository = TmdbRepositoryImp(api)
}


package com.corbettcode.myfavoritemovies.di

import com.corbettcode.myfavoritemovies.data.remote.TmdbClientApi
import com.corbettcode.myfavoritemovies.data.remote.TmdbRepositoryImp
import com.corbettcode.myfavoritemovies.ui.home.HomeViewModel

object DataModule {
    val api = TmdbClientApi
    val tmdbRepository = TmdbRepositoryImp(api)
}

object AppModule {
    val homeViewModel = HomeViewModel(DataModule.tmdbRepository)
}

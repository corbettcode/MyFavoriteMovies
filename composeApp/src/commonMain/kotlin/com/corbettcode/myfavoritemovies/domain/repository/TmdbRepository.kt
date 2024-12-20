package com.corbettcode.myfavoritemovies.domain.repository

import com.corbettcode.myfavoritemovies.domain.model.Result
import com.corbettcode.myfavoritemovies.domain.model.ResultMovie
import com.corbettcode.myfavoritemovies.domain.model.ResultTvSeries


interface TmdbRepository {
    suspend fun getTrendingList(timeWindows: String): List<Result>?
    suspend fun getDiscoverAll(mediaType: String): List<Result>?
    suspend fun getMovieList(movieListType: String): List<Result>?
    suspend fun getTVSeriesList(tvSeriesListType: String): List<Result>?
    suspend fun getList(keyType: String, key: String): List<Result>?
    suspend fun getTvSeries(tmdbId: Int): ResultTvSeries
    suspend fun getMovie(tmdbId: Int): ResultMovie
    suspend fun getSearchList(query: String, mediaType: String): List<Result>?


}

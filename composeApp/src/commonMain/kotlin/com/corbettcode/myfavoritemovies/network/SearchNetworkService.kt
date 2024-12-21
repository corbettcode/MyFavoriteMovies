package com.corbettcode.myfavoritemovies.network

import com.corbettcode.myfavoritemovies.network.ktor.KtorSearchService
import com.corbettcode.myfavoritemovies.network.model.MovieResponse
import com.corbettcode.myfavoritemovies.network.model.Result

class SearchNetworkService internal constructor(
    private val ktorSearchService: KtorSearchService
) {

    suspend fun searchMovies(
        query: String,
        language: String,
        page: Int
    ): Result<MovieResponse> {
        return ktorSearchService.searchMovies(query, language, page)
    }
}
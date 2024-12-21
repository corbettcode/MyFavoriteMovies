package com.corbettcode.myfavoritemovies.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
// import com.corbettcode.myfavoritemovies.network.config.isNeedApiKeyQuery
import com.corbettcode.myfavoritemovies.network.config.tmdbApiKey
import com.corbettcode.myfavoritemovies.network.model.MovieResponse
import com.corbettcode.myfavoritemovies.network.model.Result

internal class KtorSearchService(
    private val ktorHttpClient: HttpClient
) {

    suspend fun searchMovies(
        query: String,
        language: String,
        page: Int
    ): Result<MovieResponse> {
        return ktorHttpClient.get("search/movie") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
            parameter("query", query)
            parameter("language", language)
            parameter("page", page)
        }.body()
    }
}
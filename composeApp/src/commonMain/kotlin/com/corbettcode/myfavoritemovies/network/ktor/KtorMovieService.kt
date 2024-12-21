package com.corbettcode.myfavoritemovies.network.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
// import com.corbettcode.myfavoritemovies.network.config.isNeedApiKeyQuery
import com.corbettcode.myfavoritemovies.network.config.tmdbApiKey
import com.corbettcode.myfavoritemovies.network.model.ImagesResponse
import com.corbettcode.myfavoritemovies.network.model.Movie
import com.corbettcode.myfavoritemovies.network.model.MovieResponse
import com.corbettcode.myfavoritemovies.network.model.Result

internal class KtorMovieService(
    private val ktorHttpClient: HttpClient
) {

    suspend fun movies(
        list: String,
        language: String,
        page: Int
    ): Result<MovieResponse> {
        return ktorHttpClient.get("movie/$list") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
            parameter("language", language)
            parameter("page", page)
        }.body()
    }

    suspend fun movie(
        movieId: Int,
        language: String
    ): Movie {
        return ktorHttpClient.get("movie/$movieId") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
            parameter("language", language)
        }.body()
    }

    suspend fun images(
        movieId: Int
    ): ImagesResponse {
        return ktorHttpClient.get("movie/$movieId/images") {
            if (/* isNeedApiKeyQuery */ true) {
                parameter("api_key", tmdbApiKey)
            }
        }.body()
    }
}
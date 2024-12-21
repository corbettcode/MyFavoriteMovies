package com.corbettcode.myfavoritemovies.network

import com.corbettcode.myfavoritemovies.network.ktor.KtorMovieService
import com.corbettcode.myfavoritemovies.network.model.ImagesResponse
import com.corbettcode.myfavoritemovies.network.model.Movie
import com.corbettcode.myfavoritemovies.network.model.MovieResponse
import com.corbettcode.myfavoritemovies.network.model.Result

class MovieNetworkService internal constructor(
    private val ktorMovieService: KtorMovieService
) {

    suspend fun movies(
        list: String,
        language: String,
        page: Int
    ): Result<MovieResponse> {
        return ktorMovieService.movies(list, language, page)
    }

    suspend fun movie(
        movieId: Int,
        language: String
    ): Movie {
        return ktorMovieService.movie(movieId, language)
    }

    suspend fun images(
        movieId: Int
    ): ImagesResponse {
        return ktorMovieService.images(movieId)
    }
}
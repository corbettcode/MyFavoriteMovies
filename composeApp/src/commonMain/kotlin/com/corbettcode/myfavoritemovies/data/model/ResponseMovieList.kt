package com.corbettcode.myfavoritemovies.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.corbettcode.myfavoritemovies.domain.model.Dates
import com.corbettcode.myfavoritemovies.domain.model.Result

@Serializable
class ResponseMovieList(
    @SerialName("dates")
    val dates: Dates?,
    @SerialName("page")
    val page: Int?,
    @SerialName("results")
    val results: List<Result?>?,
    @SerialName("total_pages")
    val totalPages: Int?,
    @SerialName("total_results")
    val totalResults: Int?
)